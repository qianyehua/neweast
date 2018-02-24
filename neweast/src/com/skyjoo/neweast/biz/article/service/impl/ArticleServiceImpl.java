package com.skyjoo.neweast.biz.article.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.article.dao.ArticleDAO;
import com.skyjoo.neweast.biz.article.domain.Article;
import com.skyjoo.neweast.biz.article.domain.SubjectXArticle;
import com.skyjoo.neweast.biz.article.domain.query.ArticleCheckQuery;
import com.skyjoo.neweast.biz.article.service.ArticleService;
import com.skyjoo.neweast.biz.article.service.SubjectXArticleService;
import com.skyjoo.neweast.biz.common.enums.EnumImagePath;
import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.common.upload.UploadFileException;
import com.skyjoo.neweast.biz.common.upload.UploadFileResult;
import com.skyjoo.neweast.biz.common.upload.UploadManager;
import com.skyjoo.neweast.biz.common.util.Base64;
import com.skyjoo.neweast.biz.media.domain.enums.EnumResult;
import com.skyjoo.neweast.biz.media.domain.enums.EnumVisitType;
import com.skyjoo.neweast.biz.media.service.MediaManagerService;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Value("${article.html.filePath}")
    private String                 filePath;
    private static final String    WXHost = "mp.weixin.qq.com"; //微信文章host
    @Value("${bluefly.host}")
    private String                 host;
    @Value("${bluefly.port}")
    private String                 port;
    @Value("${bluefly.context}")
    private String                 context;
    @Autowired
    private UploadManager          uploadManager;
    @Autowired
    private SubjectXArticleService subjectXArticleService;
    @Autowired
    private MediaManagerService    mms;
    @Autowired
    private TransactionTemplate    transactionTemplate;
    //为了调用上传图片方法加上的
    private static final String[]  DEFAULT_IMAGE_SUFFIXS  = new String[] { "jpg", "jpeg", "png",
            "gif", "JPG", "JPEG", "PNG", "GIF", "bmp", "BMP" };
    private static final long      DEFAULT_IMAGE_MAX_SIZE = 2 * 1024 * 1024;                 //图片最大限制为2M
    @Value("${upload.root.path}")
    private String                  imgPath;

    @Autowired
    private ArticleDAO             articleDAO;
    private Logger    logger = Logger.getLogger(this.getClass());

    public Paginable<ArticleCheckQuery> getPaginatedArticle(Paginable<ArticleCheckQuery> page) {
        return articleDAO.getPaginategArticle(page);
    }

    public Integer addArticle(final Article article) {
        final Integer id = transactionTemplate.execute(new TransactionCallback<Integer>() {

            @Override
            public Integer doInTransaction(TransactionStatus status) {
                /*访问类型为本地转换*/
                if (mms.findMediaById(article.getMediaId()).getVisitType() == EnumVisitType.LOCAL_TRANS
                    .getValue()) {
                    if (!StringUtils.isBlank(article.getContent())) {
                        localTransContent(article);
                    }else if(!StringUtils.isBlank(article.getOriginalUrl())){
                        localTrans(article);
                    }else {
                        return -2;
                    }
                }
                
                Long id = articleDAO.addArticle(article);

                //插入失败
                if (id == null) {
                    uploadManager.deleteFile("", article.getArticlePic());
                    if (article.getTransitionPic() != null) {
                        uploadManager.deleteFile("", article.getTransitionPic());
                    }

                    return -1;
                } else {
                    //插入文章-专题关联表
                    for (Long subjectId : article.getSubjectIds()) {
                        SubjectXArticle sxa = new SubjectXArticle();
                        sxa.setArticleId(id);
                        sxa.setSubjectId(subjectId);

                        subjectXArticleService.addSubjectXArticle(sxa);
                    }
                    //=======生成文章分享二维码============
                    generateQRCode(article);
                    //==============END====================

                    articleDAO.updateArticle(article);

                    return 1;
                }
            }
        });

        return id;
    }

    public Integer update(final Article article) {
        final Integer id = transactionTemplate.execute(new TransactionCallback<Integer>() {

            @Override
            public Integer doInTransaction(TransactionStatus status) {
                //先删除文章-专题关联重新添加
                subjectXArticleService.deleteSubjectXArticle(article.getId());

                for (Long subjectId : article.getSubjectIds()) {
                    SubjectXArticle sxa = new SubjectXArticle();
                    sxa.setArticleId(article.getId());
                    sxa.setSubjectId(subjectId);

                    subjectXArticleService.addSubjectXArticle(sxa);
                }

                //生成二维码  修改文章不需要重新生成二维码
                //generateQRCode(article);

                Article art = getArticleById(article.getId());

                /*本地转换*/
                if (!art.getOriginalUrl().equals(article.getOriginalUrl())) {
                    if (mms.findMediaById(article.getMediaId()).getVisitType() == EnumVisitType.LOCAL_TRANS
                        .getValue()) {
                        if (!StringUtils.isBlank(article.getOriginalUrl())) {
                            localTrans(article);
                        } else {
                            return -2;
                        }
                    }
                }

                articleDAO.updateArticle(article);
                
                return 1;
            }
        });

        return id;
    }

    @Override
    public Article getArticleById(Long id) {
        return articleDAO.getArticleById(id);
    }

    public Integer deleteArticleByIds(String[] ids) {
        return articleDAO.deleteArticleByIds(ids);
    }

    public Integer updateArticle(Article article) {
        return articleDAO.updateArticle(article);
    }

    @Override
    public Integer getArticleCount(Long subjectId) {
        return articleDAO.getArticleCount(subjectId);
    }

    @Override
    public Integer updateCommentCount(Long id) {
        return articleDAO.updateCommentCount(id);
    }

    @Override
    public Integer removeArticleBysubjectId(Long subjectId) {
        return articleDAO.removeArticleBysubjectId(subjectId);
    }

    /**
     * 页面ajax请求获取页面内容
     */
    public String getUrlContent(String url){
        return paserHtml(url, null);
    }
    
    /**原文路径有微信文章host
     * 不再限制url
     * @param article
     * @throws FileNotFoundException
     * @throws UploadFileException
     * @throws IOException
     */
    private void localTrans(Article article) {
        //日期格式化YYYYMMDDHHMMSS
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = formatter.format(new Date()) + ".html";
        File f = new File(filePath + fileName);
        if (paserHtml(article.getOriginalUrl(), f) != null) {
            article.setLocalUrl(fileName);
        }
    }
    
    /**
     * 本地转换文章内容
     * @param article
     */
    private void localTransContent(Article article) {
        //日期格式化YYYYMMDDHHMMSS
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = formatter.format(new Date()) + ".html";
        File f = new File(filePath + fileName);
        if (paserContent(article.getContent(), f) != null) {
            article.setLocalUrl(fileName);
            if(StringUtils.isBlank(article.getOriginalUrl())){
                article.setOriginalUrl("http://" + host + ":" + port + "/article/" + fileName);
            }
        }
    }

    /**
     * 处理微信文章
     * @param url
     * @return
     */
    private String paserHtml(String url, File f) {
        Response response;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        String html = "";
        try {
            response = Jsoup
                .connect(url)
                .userAgent(
                    "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0")
                .timeout(30 * 1000).execute();

            Document doc = Jsoup.parse(response.body());
            Elements scr = doc.select("script");
            for (Element element : scr) {
                element.remove();
            }
            //针对微信链接做处理
            if(StringUtils.contains(url, WXHost)){
                Elements imges = doc.select("img[data-src]");
                for (Element element : imges) {
                    element.attr("src", "http://img04.sogoucdn.com/net/a/04/link?appid=100520033&url="
                                        + element.attr("data-src"));
                }
                Elements js = doc.select("section");
                for (Element element : js) {
                    if (element.attr("style").contains("background-image")) {
                        String urll = element.attr("style").replace("url(\"",
                            "url(\"http://img04.sogoucdn.com/net/a/04/link?appid=100520033&url=");
                        element.attr("style", urll);
                    }
                }
            }

            //删除标签之间的空格，还原文章样式
            String reg = ">\\s+([^\\s<]*)\\s+<";
            html = doc.html().replaceAll(reg, ">$1<")
                .replaceAll("<head>", "<head><meta name='referrer' content='never'>");
            StringBuffer sb = new StringBuffer(html);
            if (sb.indexOf("<style>") != -1) {
                sb.insert(sb.indexOf("<style>") + 7, "body{overflow:hidden;}");
            }
            html = sb.toString();
            if(f != null){
                osw = new OutputStreamWriter(new FileOutputStream(f),
                    response.charset());
                bw = new BufferedWriter(osw);
                bw.write(html);
            }
        } catch (IOException e) {
            return e.getMessage();
        } finally{
            try {
                if (bw != null) {
                    bw.close();
                }
                if (osw != null) {
                    osw.close();
                }
            } catch (IOException e) {
            	logger.error("close resource error：" + e );
            }
        }
        return html;
    }

    /**
     * 处理文章内容
     * @param content
     * @param f
     * @return
     */
    private String paserContent(String content, File f) {
        //对文章内容进行处理
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html><head>"+
                "<meta charset='UTF-8'>"+
                "<meta name='format-detection' content='telephone=no'/>"+
                "<meta name='viewport' content='width=device-width,height=device-height,user-scalable=no,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0'/>"+
                "</head><body><div style='max-width: 640px; margin: 0 auto;'>");
        sb.append(content);
        sb.append("</div><script src='http://code.jquery.com/jquery-1.7.2.min.js'></script>"+
                "<script>$('img').each(function(){$(this).css({'width':'auto','max-width':'100%'})});"+   
                "$('h1').css('font-size','16px');"+
                "$('p').css('text-align','center');"+
                "$('p').find('span').css('font-size','12px')"+
                "</script></body></html>");
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            String html = sb.toString();
            fos = new FileOutputStream(f);
            osw = new OutputStreamWriter(fos, "utf-8");
            bw = new BufferedWriter(osw);
            bw.write(html);
        } catch (IOException e) {
        	logger.error("close resource error：" + e );
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (osw != null) {
                    osw.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
            	logger.error("close resource error：" + e );
            }
        }
        
        return EnumResult.SUCCESS.getVal();
    }
    
    /**
     * @param article
     * @throws WriterException
     * @throws IOException
     * @throws FileNotFoundException
     * @throws UploadFileException
     */
    private void generateQRCode(Article article) {
        String filePath = "./";
        String codeURL = "http://" + host + ":" + port + context
                         + "/article/articleAshare.htm?articleId=" + article.getId();
        //        String codeURL = article.getOriginalUrl();
        String fileName = System.currentTimeMillis() + ".png";
        int width = 200;
        int height = 200;
        String format = "png";

        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");

        File file = null;
        InputStream is = null;

        try {
            BitMatrix bit = new MultiFormatWriter().encode(codeURL, BarcodeFormat.QR_CODE, width,
                height);
            Path path = FileSystems.getDefault().getPath(filePath, fileName);
            MatrixToImageWriter.writeToPath(bit, format, path);
            file = new File(filePath, fileName);
            is = new FileInputStream(file);
            MultipartFile multipartFile = fileToMultipartFile(file, is, "image/png");
            if (file.exists()) {
                UploadFileResult res = uploadManager.uploadFile(multipartFile, "code");
                article.setUrCode(res.getFilePath());
                file.delete();
            }
        } catch (WriterException | IOException | UploadFileException e) {
        	logger.error("file opt error：" + e );
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                	logger.error("close resource error：" + e );
                }
            }
        }
    }

    /**
     * file转换到multipartFile
     * @param file
     * @param is 
     * @param contentType
     * @return
     */
    private MultipartFile fileToMultipartFile(final File file, final InputStream is,
                                              final String contentType) {
        MultipartFile multipartFile = new MultipartFile() {

            @Override
            public void transferTo(File arg0) throws IOException, IllegalStateException {
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public long getSize() {
                return file.length();
            }

            @Override
            public String getOriginalFilename() {
                return file.getName();
            }

            @Override
            public String getName() {
                return file.getName();
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return is;
            }

            @Override
            public String getContentType() {
                return contentType;
            }

            @Override
            public byte[] getBytes() throws IOException {
                byte[] byt = new byte[is.available()];
                is.read(byt);
                return byt;
            }
        };
        return multipartFile;
    }
    
    /**
     * 上传裁剪后的图片base64
     * @param imgStr
     * @return
     */
    public Result<String> getUploadPic(String imgStr) {
        Result<String> result = new Result<>();
        UploadFileResult res = null;
        File file;
        if (imgStr == null){//传入内容为空   
            result.setResult("图片为空");
            return result;
        }
        
        //对base64前缀进行处理
        if(imgStr.contains("base64")){
            int index = imgStr.indexOf("base64") + 7;
            imgStr = imgStr.substring(index);
        }
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String imgFilePath = formatter.format(new Date()) + ".jpg";
        String original = imgPath + "/" + imgFilePath;
        Path path = Paths.get(original);
        try{  
            file = new File(original); 
            OutputStream out = new FileOutputStream(file);      
            out.write(Base64.decode(imgStr));  
            out.flush();  
            out.close();  
            
            //file转multipartfile
            byte[] content = null;
            content = Files.readAllBytes(path);
            MultipartFile mf = new MockMultipartFile(imgFilePath,imgFilePath, "text/plain", content);
            res = uploadManager.uploadImage(mf, false, EnumImagePath.ARTICLE.getValue(),
                DEFAULT_IMAGE_SUFFIXS, DEFAULT_IMAGE_MAX_SIZE);
            file.delete();
        }   
        catch (Exception e){  
            result.setResult(e.getMessage());
            return result;
        }  
        
        if(res == null){
            result.setResult("上传失败");
        }else{
            result.setSuccess(res.isSuccess());
            result.setResult(res.isSuccess()?res.getFilePath():res.getErrorMsg());
        }
        
        return result;
    }
}
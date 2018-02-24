package com.skyjoo.neweast.web.action.article;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.art.domain.Art;
import com.skyjoo.neweast.biz.art.domain.ArtCategory;
import com.skyjoo.neweast.biz.art.domain.query.ArtCheckQuery;
import com.skyjoo.neweast.biz.art.service.ArtCategoryService;
import com.skyjoo.neweast.biz.art.service.ArtService;
import com.skyjoo.neweast.biz.article.domain.Article;
import com.skyjoo.neweast.biz.article.domain.ArticleRecommendArt;
import com.skyjoo.neweast.biz.article.domain.query.ArticleCheckQuery;
import com.skyjoo.neweast.biz.article.domain.query.ArticleCommentQuery;
import com.skyjoo.neweast.biz.article.service.ArticleCommentService;
import com.skyjoo.neweast.biz.article.service.ArticleRecommendArtService;
import com.skyjoo.neweast.biz.article.service.ArticleService;
import com.skyjoo.neweast.biz.common.enums.EnumImagePath;
import com.skyjoo.neweast.biz.common.service.CacheService;
import com.skyjoo.neweast.biz.common.upload.UploadFileResult;
import com.skyjoo.neweast.biz.common.upload.UploadManager;
import com.skyjoo.neweast.biz.media.service.MediaManagerService;
import com.skyjoo.neweast.biz.subject.domain.Subject;
import com.skyjoo.neweast.biz.subject.service.SubjectService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;
import com.skyjoo.neweast.web.validator.ArticleValidator;

/**
 *  文章管理
 *  @author cjj
 */
@Controller
public class ArticleAction extends BaseAction {

    @Autowired
    private ArticleService         articleService;
    @Autowired
    private SubjectService         subjectService;
    @Autowired
    private MediaManagerService    mediaManagerService;
    @Autowired
    private ArticleValidator       articleValidator;
    @Autowired
    private UploadManager          uploadManager;
    @Autowired
    private ArticleCommentService  articleCommentService;
    @Autowired
    private ArticleRecommendArtService         articleRecommendArtService;
    @Autowired
    private CacheService cacheService;
    @Autowired
    private ArtService artService;
    @Autowired
    private ArtCategoryService artCategoryService;
    
    //为了调用上传图片方法加上的
    private static final String[]  DEFAULT_IMAGE_SUFFIXS  = new String[] { "jpg", "jpeg", "png",
            "gif", "JPG", "JPEG", "PNG", "GIF", "bmp", "BMP" };
    private static final long      DEFAULT_IMAGE_MAX_SIZE = 2 * 1024 * 1024;                 //图片最大限制为2M

    /**
     * 文章列表
     * @param request
     * @param article
     * @param model
     * @return
     */
    @RequestMapping("/article/list.htm")
    public String articleList(HttpServletRequest request,
                              @ModelAttribute("articleCheckQuery") ArticleCheckQuery article,
                              Model model) {
        ArticleCheckQuery articleCheckQuery = (ArticleCheckQuery) articleService
            .getPaginatedArticle(article);

        if (articleCheckQuery.getData() != null && articleCheckQuery.getData().size() > 0) {
            for (ArticleCheckQuery acq : articleCheckQuery.getData()) {
                List<Subject> subjects = subjectService.getSbListByarticleId(acq.getId());
                //组装文章所属专题
                StringBuilder up = new StringBuilder();
                for (Subject sbs : subjects) {
                    up.append(sbs.getSubjectName()).append("|");
                }
                if(up.length() > 0){
                    up.deleteCharAt(up.length() - 1);   
                }
                acq.setSubjectName(up.toString());
            }
        }

        model.addAttribute("page", articleCheckQuery);
        model.addAttribute("mediaList", mediaManagerService.list());//返回媒体列表
        model.addAttribute("subjectList", subjectService.getSubject());//返回专题列表
        return "article/list";
    }

    /**
     * 文章创建初始化
     * @param model
     * @return
     */
    @RequestMapping("/article/add-init.htm")
    public String addInit(Article article, Model model) {

        model.addAttribute("mediaList", mediaManagerService.list());//返回媒体列表
        model.addAttribute("subjectList", subjectService.getSubject());//返回专题列表

        return "/article/add";
    }

    @RequestMapping("/article/add.htm")
    public String addArticle(@ModelAttribute("article")
    final Article article, BindingResult result, Model model,
                            MultipartFile file2,
                             SystemUserAgent userAgernt) {

        String url = "/article/add";
        String addURL="/article/add-init.htm";
        model.addAttribute("mediaList", mediaManagerService.list());//返回媒体列表
        model.addAttribute("subjectList", subjectService.getSubject());//返回专题列表

        articleValidator.validate(article, result);
        if (result.hasErrors()) {
            return "/article/add";
        }

        Result<String> res = articleService.getUploadPic(article.getBasePic());
        if(res.isSuccess()){
            article.setArticlePic(res.getResult());
        }else{
            return error(model, addURL, res.getResult());
        }
        try {
            Long size2 = file2 == null ? null : file2.getSize();
            //判断上传文件大小
            if (size2 != null && size2.compareTo(2 * 1024 * 1024L) > 0){
                return error(model, addURL, "不能上传超过2M的图片！");
            }
            if (article.getVisitType() == 3) {
                if (size2 == null) {
                    return error(model, addURL, "过渡页面图片未上传");
                }

                UploadFileResult re2 = uploadManager
                    .uploadImage(file2, false, EnumImagePath.ARTICLE.getValue(),
                        DEFAULT_IMAGE_SUFFIXS, DEFAULT_IMAGE_MAX_SIZE);
                if (!re2.isSuccess()) {
                    uploadManager.deleteFile("", article.getArticlePic());
                    return error(model, addURL, "过度页面图片上传失败");
                }
                article.setTransitionPic(re2.getFilePath());
            }

            article.setStatus(0);
            Integer id = articleService.addArticle(article);

            //插入失败
            if (id == -1) {
                uploadManager.deleteFile("", article.getArticlePic());
                if (article.getTransitionPic() != null) {
                    uploadManager.deleteFile("", article.getTransitionPic());
                }

                return error(model, addURL, "插入失败");
            } else if(id == -2){
                return error(model, addURL, "当前系统仅支持微信进行本地转换!");
            } else{
                return success(model, "/article/list.htm", "插入成功");
            }
        } catch (Exception e) {
            return this.error(model, addURL, e.getMessage());
        }
    }

    /**
     * 文章编辑初始化
     * @param model
     * @return
     */
    @RequestMapping("/article/edit-init.htm")
    public String editInit(@RequestParam("id") Long id, Model model) {
        Article article = articleService.getArticleById(id);
        List<Subject> subjects = subjectService.getSbListByarticleId(id);
        List<Long> subjectIds = new ArrayList<Long>();
        for (Subject s : subjects) {
            subjectIds.add(s.getId());
        }
        article.setSubjectIds(subjectIds);

        model.addAttribute("article", article);
        //model.addAttribute("mediaList", mediaManagerService.list());//返回媒体列表
        model.addAttribute("subjectList", subjectService.getSubject());//返回专题列表

        return "/article/edit";
    }

    @RequestMapping("/article/edit.htm")
    public String editArticle(@ModelAttribute("article")
    final Article article, BindingResult result, Model model,
                              MultipartFile file2,
                              SystemUserAgent userAgernt) {

        String url = "/article/edit-init.htm?id="+article.getId();

        //model.addAttribute("mediaList", mediaManagerService.list());//返回媒体列表
        model.addAttribute("subjectList", subjectService.getSubject());//返回专题列表

        articleValidator.validate(article, result);
        if (result.hasErrors()) {
            return "/article/edit";
        }
        
        if(!StringUtil.isBlank(article.getBasePic())){
            Result<String> res = articleService.getUploadPic(article.getBasePic());
            if(res.isSuccess()){
                article.setArticlePic(res.getResult());
            }else{
                return error(model, url, res.getResult());
            }
        }
        
        try {
            Long size2 = file2 == null ? null : file2.getSize();

            //判断上传文件大小
            if (size2 != null && size2.compareTo(2 * 1024 * 1024L) > 0) {
                return error(model, url, "不能上传超过2M的图片！");
            }

            if (size2 != null && size2 > 0) {
                UploadFileResult re2 = uploadManager
                    .uploadImage(file2, false, EnumImagePath.ARTICLE.getValue(),
                        DEFAULT_IMAGE_SUFFIXS, DEFAULT_IMAGE_MAX_SIZE);
                if (!re2.isSuccess()) {
                    return error(model, url, "过度页面图片上传失败");
                }
                uploadManager.deleteFile("", article.getTransitionPic());
                article.setTransitionPic(re2.getFilePath());
            }

            article.setStatus(0);
            Integer id = articleService.update(article);

            //更新失败
            if (id == -1) {
                if (size2 > 0) {
                    uploadManager.deleteFile("", article.getTransitionPic());
                }

                return error(model, url, "更新失败");
            } else if(id == -2){
                return error(model, url, "当前系统仅支持微信进行本地转换!");
            }else{
                return success(model, "/article/list.htm", "更新成功");
            }

        } catch (Exception e) {
            return this.error(model, url, e.getMessage());
        }
    }

    /**
     * 初始化文章审核
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/article/check_edit.htm")
    public String check_editIni(@RequestParam("id") Long id, HttpServletRequest request, Model model) {
        Article article = articleService.getArticleById(id);
        List<Subject> subjects = subjectService.getSbListByarticleId(id);
        //组装文章所属专题
        StringBuilder up = new StringBuilder();
        for (Subject sbs : subjects) {
            up.append(sbs.getSubjectName()).append("|");
        }
        up.deleteCharAt(up.length() - 1);
        article.setSubjects(up.toString());
        model.addAttribute("article", article);
        
        List<ArticleRecommendArt> articleRecommendArt = articleRecommendArtService.getRecommendArtByArticleId(id);
        model.addAttribute("articleRecommendArt", articleRecommendArt);
        
        return getReturnPage("check_edit.htm");

    }

    /**
     * 文章审核
     * @param agent
     * @param request
     * @param article
     * @param model
     * @return
     */
    @RequestMapping("/article/check.htm")
    public String check_edit(SystemUserAgent agent, HttpServletRequest request,
                             @ModelAttribute("article") Article article, Model model) {

        article.setId(Long.parseLong(request.getParameter("id")));
        article.setStatus(Integer.parseInt(request.getParameter("checkResult")));
        Integer checkResult = articleService.updateArticle(article);
        String url = "/article/list.htm";

        return checkResult == 0 ? "error" : success(model, url, "操作成功");

    }

    /**
     * 文章详情
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/article/detail.htm")
    public String detail(@RequestParam("id") Long id, HttpServletRequest request, Model model) {
        Article article = articleService.getArticleById(id);
        List<Subject> subjects = subjectService.getSbListByarticleId(id);
        //组装文章所属专题
        StringBuilder up = new StringBuilder();
        for (Subject sbs : subjects) {
            up.append(sbs.getSubjectName()).append("|");
        }
        if(up.length() > 0){
            up.deleteCharAt(up.length() - 1);
        }
        article.setSubjects(up.toString()); 
        model.addAttribute("article", article);
        return getReturnPage("detail");

    }

    private String getReturnPage(String string) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 文章删除
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/article/remove.htm")
    public String remove(String id, Model model) {
        String[] str = { id };

        Integer length = articleService.deleteArticleByIds(str);

        if (length == 0) {
            return "error";
        }

        return success(model, "/article/list.htm", "删除成功");
    }

    /**
     * 文章批量删除
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/article/batchRemove.htm")
    public String batchRemove(String ids, Model model) {
        String[] str = ids.split(",");

        if (str.length == 0) {
            return "error";
        }

        Integer length = articleService.deleteArticleByIds(str);
        if (length == 0) {
            return "error";
        }

        return success(model, "/article/list.htm", "批量删除成功");
    }

    /**
     * 文章评论列表
     * @param request
     * @param articleCommentQuery
     * @param model
     * @return
     */
    @RequestMapping("/article/comment.htm")
    public String commentList(HttpServletRequest request,
                              @ModelAttribute("query") ArticleCommentQuery query, ModelMap model) {
        articleCommentService.getArticleComment(query);
        model.addAttribute("query", query);
        return getReturnPage("comment");

    }

    /**
     * 文章评论删除
     * @param id
     * @param model
     * @return
     */

    @RequestMapping("/article/removeComment.htm")
    public String removeComment(@RequestParam("articleId") Long articleId, String id, Model model) {
        String[] str = { id };
        for (int i = 0; i < str.length; i++) {
            articleCommentService.deleteCommentByIds(Long.valueOf(str[i])
                .longValue());
        }
        articleService.updateCommentCount(articleId);
        return success(model, "/article/comment.htm?articleId="+articleId, "删除成功");
    }

    /**
     * 批量删除文章评价
     * @param ids
     * @param model
     * @return
     */
    @RequestMapping("/article/batchRemoveComment.htm")
    public String bathcRemoveComment(String ids, Long articleId, Model model) {
        String[] str = ids.split(",");
        for (int i = 0; i < str.length; i++) {
            Long.valueOf(str[i]).longValue();
            articleCommentService.deleteCommentByIds(Long.valueOf(str[i])
                .longValue());
        }
        articleService.updateCommentCount(articleId);
        return success(model, "/article/comment.htm?articleId="+articleId, "批量删除成功");
    }
    /**
     * 文章推广
     * @param id
     * @param request
     * @param model
     * @return
     */
    
    @RequestMapping("/article/recommend.htm")
    public String recommend(@RequestParam("id") Long id, HttpServletRequest request, Model model) {
        Article article = articleService.getArticleById(id);
        List<Subject> subjects = subjectService.getSbListByarticleId(id);
        //组装文章所属专题
        StringBuilder up = new StringBuilder();
        for (Subject sbs : subjects) {
            up.append(sbs.getSubjectName()).append("|");
        }
        if(up.length() > 0){
            up.deleteCharAt(up.length() - 1);
        }
        article.setSubjects(up.toString()); 
        List<ArticleRecommendArt> articleRecommendArt = articleRecommendArtService.getRecommendArtByArticleId(id);
        //文章详情
        model.addAttribute("article", article);
        model.addAttribute("articleRecommendArt", articleRecommendArt);
        return getReturnPage("recommend");

    }
    /**
     * 初始化增加推广艺术品
     * @param articleId
     * @param art
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/article/addRecommendArtIni.htm",method=RequestMethod.GET)
    public String addRecommendArtIni(@RequestParam("articleId") Long articleId, @ModelAttribute("artCheckQuery")ArtCheckQuery art,HttpServletRequest request, Model model){
        model.addAttribute("list_menus", cacheService.getArtCategoryNames());
        model.addAttribute("articleId", articleId);  
        return "/article/addRecommendArt"; 
        
    }
    /**
     * 增加推广艺术品
     * @param art
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/article/addRecommendArt.htm",method=RequestMethod.GET)
    public String addRecommendArt(@RequestParam("articleId") Long articleId,@ModelAttribute("artCheckQuery")ArtCheckQuery art, HttpServletRequest request, Model model) {
        art.setArtType("1");
        art.setIsAll(3);
        art.setArticleId(articleId);
        Long categoryId = art.getCategoryId();
        if(categoryId != null){
            ArtCategory artCategory = artCategoryService.getCategoryListbyId(categoryId);
            if(artCategory.getParentId() == 0){
                art.setArtParentCategoryId(categoryId);
                art.setCategoryId(null);
            }
        }   
        //art.setIsArtiseWork(true);
        ArtCheckQuery artCheckQuery = (ArtCheckQuery) artService.getPaginatedRecommendArt(art);
        artCheckQuery.setCategoryId(categoryId);
        model.addAttribute("articleId", articleId);  
        model.addAttribute("page", artCheckQuery);  
        model.addAttribute("list_menus", cacheService.getArtCategoryNames());
        return getReturnPage("addRecommendArt"); 
        
    }
    /**
     * 批量推广艺术品
     * @param ids
     * @param articleId
     * @param model
     * @return
     */
    @RequestMapping("/article/batchAddRecommendArt.htm")
    public String batchAddRecommendArt(String ids, Long articleId, Model model) {
        String[] str = ids.split(",");
        List<ArticleRecommendArt> articleRecommendArts =  new ArrayList<ArticleRecommendArt>();
        for (int i = 0; i < str.length; i++) {
            ArticleRecommendArt recommendArt = new ArticleRecommendArt();
            recommendArt.setArticleId(articleId);
            recommendArt.setArtId(Long.valueOf(str[i]).longValue());           
            articleRecommendArts.add(recommendArt);
        }
        articleRecommendArtService.batchAddRecomendArts(articleRecommendArts);
        Article article = new Article();
        article.setId(articleId);
        article.setStatus(0);
        Integer res = articleService.updateArticle(article);
        return success(model, "/article/recommend.htm?id="+articleId, "推广成功");
    } 
    
    /**
     * 初始化编辑推广介绍
     * @param id
     * @param artId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="/article/editRecommendArt.htm",method=RequestMethod.GET)
    public String editRecommend(@RequestParam("id") Long id,@RequestParam("artId") Long artId, HttpServletRequest request, Model model) {
        
      //获取艺术品详情 
        List<Art> list_art = artService.getArtInformById(Long.parseLong(request.getParameter("artId")));
        if(list_art != null && list_art.size() > 0){
            Art art = list_art.get(0);
            model.addAttribute("art", art); 
            String[] propertyContent = art.getProperty().split(";");    
            model.addAttribute("propertyContent", propertyContent);
            String attach = list_art.get(0).getAttachment();
                if(attach != null && !"".equals(attach)){
                String[] imgStr = attach.split("\\|");
                model.addAttribute("imgStr",imgStr);
            }
        }
       ArticleRecommendArt articleRecommendArt = articleRecommendArtService.getRecommendArt(id);
       model.addAttribute("articleRecommendArt", articleRecommendArt); 
        
        return  "article/editRecommendArt";

    }
    /**
     * 编辑推广介绍
     * @param articleId
     * @param articleRecommendArt
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="/article/editRecommendArt.htm",method = RequestMethod.POST)
    public String editRecommendIni(@RequestParam("articleId") Long articleId,@ModelAttribute("articleRecommendArt") ArticleRecommendArt articleRecommendArt, HttpServletRequest request, Model model) {
       
        Integer id =articleRecommendArtService.editArticleRecommendArt(articleRecommendArt);
        if(id != 0) {
            Article article = new Article();
            article.setId(articleId);
            article.setStatus(0);
            Integer res = articleService.updateArticle(article);
            return  success(model, "/article/recommend.htm?id="+articleId, "操作成功");
        }else {
            return  error(model, "/article/recommend.htm?id="+articleId, "操作失败");
        }     
    }
    
    @RequestMapping(value = "/article/removeRecommendArt.htm")
    public String remove(@RequestParam("id") Long id, @RequestParam("articleId") Long articleId,Model model) {
        
        int i =articleRecommendArtService.removeRecommendArt(id);
        if(i != 0) {
            return  success(model, "/article/recommend.htm?id="+articleId, "操作成功");
        }else {
            return  error(model, "/article/recommend.htm?id="+articleId, "操作失败");
        }     
    }
}

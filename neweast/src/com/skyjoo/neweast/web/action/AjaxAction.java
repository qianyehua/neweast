package com.skyjoo.neweast.web.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.eyeieye.melos.web.url.URLBroker;
import com.skyjoo.neweast.biz.article.service.ArticleService;
import com.skyjoo.neweast.biz.common.enums.EnumImagePath;
import com.skyjoo.neweast.biz.common.upload.UploadFileException;
import com.skyjoo.neweast.biz.common.upload.UploadFileResult;
import com.skyjoo.neweast.biz.common.upload.UploadManager;
import com.skyjoo.neweast.biz.common.util.Base64;
import com.skyjoo.neweast.biz.datadic.domain.SimpleCity;
import com.skyjoo.neweast.biz.datadic.service.ProvinceCityService;

@Controller
@RequestMapping("ajax/")
public class AjaxAction extends BaseAction {
	@Autowired
	private ProvinceCityService 	provinceCityService;
	
    @Autowired
    private UploadManager           uploadManager;	
    @Autowired
    private ArticleService          articleService;  

    @Resource(name = "uploadServerBroker")
    private URLBroker      uploadServer;
	
	@RequestMapping(value="city.htm", method=RequestMethod.GET)
	public @ResponseBody List<SimpleCity> city() {
		return provinceCityService.getSimpleProvinceCityList();
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws UploadFileException
	 */
	@RequestMapping(value="upload.htm")
    public String ajaxMessageCount(HttpServletRequest request,HttpServletResponse response, ModelMap model) throws UploadFileException{
	    //uploadManager.uploadImage(image, isCompress)
	    MultipartRequest mrequest = (MultipartRequest) request; 
	    Map map=mrequest.getFileMap();  
	    Collection<MultipartFile> collection = map.values();  
	    MultipartFile mfile = null;
	    Iterator it = collection.iterator(); 
	    JSONObject obj = new JSONObject();
        
	    while (it.hasNext()) { 
	        mfile = (MultipartFile) it.next();
	        UploadFileResult result = uploadManager.uploadImage(mfile, false);
	        if(result.isSuccess()){
	            obj.put("error", 0);
	            obj.put("url", uploadServer.get(result.getFilePath()).toString());
	        }else{
	            obj.put("error", 1);
	            obj.put("url", result.getErrorMsg());
	        }
	    }
	   PrintWriter writer = null;
       try {
           response.setContentType("text/html;charset=utf-8");
           response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            writer.write(obj.toJSONString());
        } catch (IOException e) {
            logger.error("ajaxMessageCount error£º" + e );
        } finally {
            writer.flush();
            writer.close();
        }   

       return null;
    }
	
    @RequestMapping(value = "article/getUrlContent.htm", method = RequestMethod.GET)
    @ResponseBody
    public String getUrlContent(String url) {
        JSONObject json = new JSONObject();
        json.put("content", articleService.getUrlContent(url));
        return json.toString();
    }
}

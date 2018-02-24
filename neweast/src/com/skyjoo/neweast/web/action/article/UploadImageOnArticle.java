package com.skyjoo.neweast.web.action.article;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.baidu.ueditor.define.MIMEType;
import com.google.gson.Gson;
import com.skyjoo.neweast.biz.common.upload.OSSUploadManagerImpl;
import com.skyjoo.neweast.biz.common.upload.UploadFileException;
import com.skyjoo.neweast.biz.common.upload.UploadFileResult;
import com.skyjoo.neweast.biz.common.upload.UploadManager;
import com.skyjoo.neweast.biz.common.upload.UploadManagerImpl;

/**
 * 上传在文章自定义编辑时上传的图片
 * 
 * @author Administrator
 *
 */
public class UploadImageOnArticle {
//	private UploadManager uploadManager ;
	private Logger logger = Logger.getLogger(this.getClass());
	WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
	UploadManager uploadManager = (UploadManager) wac.getBean("uploadManager");

	public UploadImageOnArticle() {
	}
	/**
	 * 上传在文章自定义编辑时上传的图片
	 * 
	 * @author Administrator
	 *
	 */
	public String upload(HttpServletRequest request, String json) {
		Gson gson = new Gson();
		Map<String, String> map = gson.fromJson(json, Map.class);
		if (!map.containsKey("url")) {
			return json;
		}
		String fs = request.getSession().getServletContext().getRealPath("/");
		File f = new File(fs + map.get("url"));
		InputStream is;
		try {

			is = new FileInputStream(f);
			String type = "image/png";
			for (Entry<String, String> e : MIMEType.types.entrySet()) {
				if (e.getValue().equalsIgnoreCase(map.get("type"))) {
					type = e.getKey();
				}
			}
			MultipartFile mf = fileToMultipartFile(f, is, type);
			UploadFileResult res = uploadManager.uploadImage(mf, false, "articlePic");
			is.close();
			f.delete();
			if (res.isSuccess()) {
				map.put("url", res.getFilePath());
			}
		} catch (FileNotFoundException e) {
			logger.error("file opt error：" + e );
		} catch (UploadFileException e) {
			logger.error("file opt error：" + e );
		} catch (IOException e) {
			logger.error("file opt error：" + e );
		}
		return new JSONObject().fromObject(map).toString();
	}

	/**
	 * file转换到multipartFile
	 * 
	 * @param file
	 * @param is
	 * @param contentType
	 * @return
	 */
	private MultipartFile fileToMultipartFile(final File file,
			final InputStream is, final String contentType) {
		MultipartFile multipartFile = new MultipartFile() {

			@Override
			public void transferTo(File arg0) throws IOException,
					IllegalStateException {
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
}

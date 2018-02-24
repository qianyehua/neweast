package com.skyjoo.neweast.web.action.subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.skyjoo.neweast.biz.article.service.ArticleService;
import com.skyjoo.neweast.biz.article.service.SubjectXArticleService;
import com.skyjoo.neweast.biz.common.enums.EnumImagePath;
import com.skyjoo.neweast.biz.common.upload.UploadFileException;
import com.skyjoo.neweast.biz.common.upload.UploadFileResult;
import com.skyjoo.neweast.biz.common.upload.UploadManager;
import com.skyjoo.neweast.biz.subject.domain.Subject;
import com.skyjoo.neweast.biz.subject.service.SubjectService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;
@Controller
public class SubjectAction  extends BaseAction{
	
	@Autowired 
	private SubjectService subjectService;
	@Autowired
	private UploadManager uploadManager;
    @Autowired 
    private ArticleService articleService;
    @Autowired
    private SubjectXArticleService subjectXArticleService;
	/**
	 * 添加初始化
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value = "/subject/add-init.htm")
	public String addInit(Model model){
		
		return "/subject/add";
	}
	
	
	/**
	 * 专题添加
	 */
	@RequestMapping(value = "/subject/add.htm")
	public String add(@ModelAttribute("sb") Subject sb, BindingResult result,
			Model model, @RequestParam("file") MultipartFile file,
			SystemUserAgent userAgernt) {
		// 定义返回目标
		String url = "/subject/list.htm";
		Subject sb1 = subjectService.searchsbName(sb.getSubjectName());
		if (sb1 == null) {
			try {
				Long size = file.getSize();
				// 判断上传文件大小
				if (size.compareTo(1024 * 1024L) > 0) {
					return error(model, url, "不能上传超过1M的图片！");
				}
				// 上传图片
				UploadFileResult re = uploadManager.uploadImage(file, false,
						EnumImagePath.HOMEPAGE.getValue());
				if (re.isSuccess()) {
					sb.setSubjectPic(re.getFilePath());
					// 向数据库中存储
					Long id = subjectService.addsubjectService(sb);
					if (id == null) {
						// 从服务器上删除图片
						uploadManager.deleteFile("", sb.getSubjectPic());
						return error(model, url, "向数据库添加失败");
					} else {
						return success(model, url, "添加成功");
					}
				} else {
					return error(model, url, "图片上传失败");
				}
			} catch (UploadFileException e) {
				return this.error(model, url, e.getMessage());
			}
		} else {
			return error(model, url, "操作失败,该专题名已经存在!");
		}
	}
	
	
	/**
	 * 专题列表
	 */
	@RequestMapping(value = "/subject/list.htm")
	public String list( Model model){
		List<Subject> list_subject = subjectService.getSubject();
		model.addAttribute("list_subject",list_subject);
		return getReturnPage("list");
	}


	private String getReturnPage(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 专题编辑初始化
	 */
	 @RequestMapping(value = "/subject/edit.htm",method=RequestMethod.GET)
	 public String edit(@RequestParam("id") Long id, Model model,
	            SystemUserAgent userAgernt) {
	        Subject sb = subjectService.getSubjectById(id);
	        model.addAttribute("subject",sb);
	        return "/subject/edit";
	    }	
	    
	
	
	/**
	 * 专题编辑
	 */
	@RequestMapping(value = "/subject/edit.htm", method = RequestMethod.POST)
	public String sbedit(@ModelAttribute("sb") Subject sb,
			BindingResult result, Model model,
			@RequestParam("file") MultipartFile file, SystemUserAgent userAgernt) {

		String url = "/subject/list.htm";
		Subject sb1 = subjectService.searchsbName(sb.getSubjectName());
		if (sb1 == null) {
			try {
				Long size = file.getSize();
				if (size > 0) {
					// 判断上传文件大小
					if (size.compareTo(1024 * 1024L) > 0) {
						return error(model, url, "不能上传超过1M的图片！");
					}
					// 上传图片
					UploadFileResult re = uploadManager.uploadImage(file,
							false, EnumImagePath.HOMEPAGE.getValue());
					if (re.isSuccess()) {
						sb.setSubjectPic(re.getFilePath());
						// 向数据库中存储
						Integer id = subjectService.updateSubject(sb);
						if (id == 0) {
							// 从服务器上删除图片
							uploadManager.deleteFile("", sb.getSubjectPic());
							return error(model, url, "向数据修改加失败");
						} else {
							return success(model, url, "修改成功");
						}

					} else {
						return error(model, url, "图片上传失败");
					}
				} else {
					Integer id = subjectService.updateSubject(sb);
					if (id == 0) {
						// 从服务器上删除图片
						uploadManager.deleteFile("", sb.getSubjectPic());
						return error(model, url, "向数据修改加失败");
					} else {
						return success(model, url, "修改成功");
					}
				}
			} catch (UploadFileException e) {
				return this.error(model, url, e.getMessage());
			}
		} else {
			if (sb1.getId().equals(sb.getId())) {
				try {
					Long size = file.getSize();
					if (size > 0) {
						// 判断上传文件大小
						if (size.compareTo(1024 * 1024L) > 0) {
							return error(model, url, "不能上传超过1M的图片！");
						}
						// 上传图片
						UploadFileResult re = uploadManager.uploadImage(file,
								false, EnumImagePath.HOMEPAGE.getValue());
						if (re.isSuccess()) {
							sb.setSubjectPic(re.getFilePath());
							// 向数据库中存储
							Integer id = subjectService.updateSubject(sb);
							if (id == 0) {
								// 从服务器上删除图片
								uploadManager
										.deleteFile("", sb.getSubjectPic());
								return error(model, url, "向数据修改加失败");
							} else {
								return success(model, url, "修改成功");
							}

						} else {
							return error(model, url, "图片上传失败");
						}
					} else {
						Integer id = subjectService.updateSubject(sb);
						if (id == 0) {
							// 从服务器上删除图片
							uploadManager.deleteFile("", sb.getSubjectPic());
							return error(model, url, "向数据修改加失败");
						} else {
							return success(model, url, "修改成功");
						}
					}
				} catch (UploadFileException e) {
					return this.error(model, url, e.getMessage());
				}

			} else {
				return error(model, url, "操作失败,该专题名已经存在!");
			}
		}
	}
	
	@RequestMapping(value = "/subject/remove.htm")
	public String remove(@RequestParam("id") Long id, Model model,
			SystemUserAgent userAgernt) {
	       String url ="/subject/list.htm";
	    Integer a = articleService.getArticleCount(id);
	    if(a == 0){
		Subject sb = subjectService.getSubjectById(id);
		//删除图片
		uploadManager.deleteFile("", sb.getSubjectPic());
		//删除专题关联文章
		subjectXArticleService.removeSubjectXArticle(id);		
		//从数据库删除记录
		Integer i = subjectService.removeSubject(sb);
		return i!=null?success(model,url,"删除成功"):error(model,url,"删除失败");}
	    else{
	        return error(model,url,"删除失败,该专题下有文章");
	    }
	}
	 
}

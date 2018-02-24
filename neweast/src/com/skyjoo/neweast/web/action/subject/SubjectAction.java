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
	 * ��ӳ�ʼ��
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value = "/subject/add-init.htm")
	public String addInit(Model model){
		
		return "/subject/add";
	}
	
	
	/**
	 * ר�����
	 */
	@RequestMapping(value = "/subject/add.htm")
	public String add(@ModelAttribute("sb") Subject sb, BindingResult result,
			Model model, @RequestParam("file") MultipartFile file,
			SystemUserAgent userAgernt) {
		// ���巵��Ŀ��
		String url = "/subject/list.htm";
		Subject sb1 = subjectService.searchsbName(sb.getSubjectName());
		if (sb1 == null) {
			try {
				Long size = file.getSize();
				// �ж��ϴ��ļ���С
				if (size.compareTo(1024 * 1024L) > 0) {
					return error(model, url, "�����ϴ�����1M��ͼƬ��");
				}
				// �ϴ�ͼƬ
				UploadFileResult re = uploadManager.uploadImage(file, false,
						EnumImagePath.HOMEPAGE.getValue());
				if (re.isSuccess()) {
					sb.setSubjectPic(re.getFilePath());
					// �����ݿ��д洢
					Long id = subjectService.addsubjectService(sb);
					if (id == null) {
						// �ӷ�������ɾ��ͼƬ
						uploadManager.deleteFile("", sb.getSubjectPic());
						return error(model, url, "�����ݿ����ʧ��");
					} else {
						return success(model, url, "��ӳɹ�");
					}
				} else {
					return error(model, url, "ͼƬ�ϴ�ʧ��");
				}
			} catch (UploadFileException e) {
				return this.error(model, url, e.getMessage());
			}
		} else {
			return error(model, url, "����ʧ��,��ר�����Ѿ�����!");
		}
	}
	
	
	/**
	 * ר���б�
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
	 * ר��༭��ʼ��
	 */
	 @RequestMapping(value = "/subject/edit.htm",method=RequestMethod.GET)
	 public String edit(@RequestParam("id") Long id, Model model,
	            SystemUserAgent userAgernt) {
	        Subject sb = subjectService.getSubjectById(id);
	        model.addAttribute("subject",sb);
	        return "/subject/edit";
	    }	
	    
	
	
	/**
	 * ר��༭
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
					// �ж��ϴ��ļ���С
					if (size.compareTo(1024 * 1024L) > 0) {
						return error(model, url, "�����ϴ�����1M��ͼƬ��");
					}
					// �ϴ�ͼƬ
					UploadFileResult re = uploadManager.uploadImage(file,
							false, EnumImagePath.HOMEPAGE.getValue());
					if (re.isSuccess()) {
						sb.setSubjectPic(re.getFilePath());
						// �����ݿ��д洢
						Integer id = subjectService.updateSubject(sb);
						if (id == 0) {
							// �ӷ�������ɾ��ͼƬ
							uploadManager.deleteFile("", sb.getSubjectPic());
							return error(model, url, "�������޸ļ�ʧ��");
						} else {
							return success(model, url, "�޸ĳɹ�");
						}

					} else {
						return error(model, url, "ͼƬ�ϴ�ʧ��");
					}
				} else {
					Integer id = subjectService.updateSubject(sb);
					if (id == 0) {
						// �ӷ�������ɾ��ͼƬ
						uploadManager.deleteFile("", sb.getSubjectPic());
						return error(model, url, "�������޸ļ�ʧ��");
					} else {
						return success(model, url, "�޸ĳɹ�");
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
						// �ж��ϴ��ļ���С
						if (size.compareTo(1024 * 1024L) > 0) {
							return error(model, url, "�����ϴ�����1M��ͼƬ��");
						}
						// �ϴ�ͼƬ
						UploadFileResult re = uploadManager.uploadImage(file,
								false, EnumImagePath.HOMEPAGE.getValue());
						if (re.isSuccess()) {
							sb.setSubjectPic(re.getFilePath());
							// �����ݿ��д洢
							Integer id = subjectService.updateSubject(sb);
							if (id == 0) {
								// �ӷ�������ɾ��ͼƬ
								uploadManager
										.deleteFile("", sb.getSubjectPic());
								return error(model, url, "�������޸ļ�ʧ��");
							} else {
								return success(model, url, "�޸ĳɹ�");
							}

						} else {
							return error(model, url, "ͼƬ�ϴ�ʧ��");
						}
					} else {
						Integer id = subjectService.updateSubject(sb);
						if (id == 0) {
							// �ӷ�������ɾ��ͼƬ
							uploadManager.deleteFile("", sb.getSubjectPic());
							return error(model, url, "�������޸ļ�ʧ��");
						} else {
							return success(model, url, "�޸ĳɹ�");
						}
					}
				} catch (UploadFileException e) {
					return this.error(model, url, e.getMessage());
				}

			} else {
				return error(model, url, "����ʧ��,��ר�����Ѿ�����!");
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
		//ɾ��ͼƬ
		uploadManager.deleteFile("", sb.getSubjectPic());
		//ɾ��ר���������
		subjectXArticleService.removeSubjectXArticle(id);		
		//�����ݿ�ɾ����¼
		Integer i = subjectService.removeSubject(sb);
		return i!=null?success(model,url,"ɾ���ɹ�"):error(model,url,"ɾ��ʧ��");}
	    else{
	        return error(model,url,"ɾ��ʧ��,��ר����������");
	    }
	}
	 
}

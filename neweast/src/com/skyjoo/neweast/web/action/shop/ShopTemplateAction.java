package com.skyjoo.neweast.web.action.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.skyjoo.neweast.biz.common.enums.EnumImagePath;
import com.skyjoo.neweast.biz.common.upload.UploadFileException;
import com.skyjoo.neweast.biz.common.upload.UploadFileResult;
import com.skyjoo.neweast.biz.common.upload.UploadManager;
import com.skyjoo.neweast.biz.shop.domain.ShopTemplate;
import com.skyjoo.neweast.biz.shop.service.ShopTemplateService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;
import com.skyjoo.neweast.web.validator.shop.ShopTemplateValidator;

@Controller
@RequestMapping("shop/template/")
public class ShopTemplateAction extends BaseAction {
	
	@Autowired
	private ShopTemplateService shopTemplateService;
	@Autowired 
	private ShopTemplateValidator shopTemplateValidator;
	@Autowired 
	private UploadManager uploadManager;
	
	private static final String baseVMPath = "shop/template/";
	private String getReturnPage(String page) {
		return baseVMPath.concat(page);
	}
	
	/** ����ģ���б� **/
	@RequestMapping(value="list.htm")
	public String list(@ModelAttribute("query") ShopTemplate query, ModelMap model) {
		
		shopTemplateService.getShopTemplatePage(query);
		return getReturnPage("list");
	}
	
	
	/** ����ģ������ **/
	@RequestMapping(value="detail.htm")
	public String detail(@RequestParam("id") Long id , ModelMap model) {
		
		ShopTemplate template = shopTemplateService.getShopTemplateByID(id);
		model.addAttribute("template", template);
		
		return getReturnPage("detail");
		
	}
	
	
	/** ��������ģ��ҳ�� **/
	@RequestMapping(value="add-init.htm")
	public String addInit(@ModelAttribute("template") ShopTemplate template, ModelMap model) {
		
		return getReturnPage("add");
		
	}
	
	/** ��������ģ�� **/
	@RequestMapping(value="add.htm")
	public String add(@ModelAttribute("template") ShopTemplate template,BindingResult result,
			ModelMap model,@RequestParam("file") MultipartFile file, SystemUserAgent agent) {
		
		String url = "/shop/template/list.htm";
		model.addAttribute("url", url);
		
		shopTemplateValidator.validate(template, result);
		if(result.hasErrors()){
			return getReturnPage("add");
		}
		if(file==null){
			model.put("file", "��ѡ��Ԥ��ͼ");
			return getReturnPage("add");
		}
		//title Ψһ
		if(shopTemplateService.hasTitle(template.getTitle())){
			model.put("hasRegister", "ģ������Ѿ����ڣ�");
			return getReturnPage("add");
		}

		try {

			//�ϴ�ͼƬ
			UploadFileResult re = uploadManager.uploadImage(file,false,EnumImagePath.SHOPTEMPLATEPREVIEW.getValue());
			if(re.isSuccess()){
				//ͼƬ·��
				template.setPreviewPic(re.getFilePath());
				template.setStatus(1);//״̬��0 δ���� 1 ������-1 ��ɾ��
				
				//�����ݿ��д洢 ShopTemplate
				Long id = shopTemplateService.addShopTemplate(template);
				if(id==null){
					//�ӷ�������ɾ��ͼƬ
					uploadManager.deleteFile("", template.getPreviewPic());
					return error(model);
				}else{
					return success(model);
				}
			}else{
				return error(model);
			}
		} catch (UploadFileException e) {
			return this.error(model);
		}
		
	}

	/** ��������ģ��ҳ�� **/
	@RequestMapping(value="remove.htm")
	public String remove(@RequestParam("id") Long id , ModelMap model) {
		
		String url = "/shop/template/list.htm";
		model.addAttribute("url", url);
		
		Integer ret =shopTemplateService.remove(id);
		
		return ret>0?success():error();
		
	}
}

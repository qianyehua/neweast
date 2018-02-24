/**
 * 
 */
package com.skyjoo.neweast.web.action.homepage;

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

import com.skyjoo.neweast.biz.common.enums.EnumImagePath;
import com.skyjoo.neweast.biz.common.upload.UploadFileException;
import com.skyjoo.neweast.biz.common.upload.UploadFileResult;
import com.skyjoo.neweast.biz.common.upload.UploadManager;
import com.skyjoo.neweast.biz.homepage.domain.EnumHomePageType;
import com.skyjoo.neweast.biz.homepage.domain.common.HomepagePic;
import com.skyjoo.neweast.biz.homepage.service.HomepagePicService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;

/**
 * ��ҳͼƬ����ҳ��
 * @author liupc
 * @date 2014-11-12 10:48:13
 */
@Controller
public class HomepagePicAction extends BaseAction {

    @Autowired
    HomepagePicService    homepagePicService;

    @Autowired
    private UploadManager uploadManager;

    /**
     * ��ҳͼƬ�б�
     * @param model
     * @return
     */
    @RequestMapping(value = "/homepage/pic/list.htm")
    public String list(Model model) {
        List<HomepagePic> list_pics = homepagePicService.getHomepagePic();
        model.addAttribute("list_pics", list_pics);
        return "/homepage/pic/list";
    }

    /**
     * ��ӳ�ʼ��
     * @param hp
     * @param result
     * @param model
     * @return
     */
    @RequestMapping(value = "/homepage/pic/add-init.htm")
    public String addInit(Model model) {
        if (homepagePicService.getHomepagePic().size() == 10) {
            return error(model, "/homepage/pic/list.htm", "�Ѿ�10��ͼƬ,�����������");
        }
        model.addAttribute("types", EnumHomePageType.values());
        return "/homepage/pic/add";
    }

    /**
     * �����ҳͼƬ
     * @param hp
     * @param result
     * @param model
     * @param file
     * @param userAgernt
     * @return
     */
    @RequestMapping(value = "/homepage/pic/add.htm")
    public String add(@ModelAttribute("hp") HomepagePic hp, BindingResult result, Model model,
                      @RequestParam("file") MultipartFile file, SystemUserAgent userAgernt) {
        //���巵��Ŀ��
        String url = "/homepage/pic/list.htm";
        if (hp.getType() == 1) {
            if (homepagePicService.getPCHomepage().size()>=5) {
                return error(model, url, "PC���Ѿ���5��ͼƬ,�����������");
            }
        } else if (hp.getType() == 2) {
            if (homepagePicService.getAPPHomepage().size()>=5) {
                return error(model, url, "APP���Ѿ���5��ͼƬ,�����������");
            }
        }
        else if (hp.getType() == 3) {
            if (homepagePicService.getAPPStartHomepage().size()>=1) {
                return error(model, url, "APP����ҳ���һ��ͼƬ,�����������");
            }
        } else {
            return error(model, url, "ͼƬ���ʹ���");
        }
        //        if (homepagePicService.getHomepagePic().size() == 5) {
        //            return error(model, url, "�Ѿ�5��ͼƬ,�����������");
        //        }
        try {
            Long size = file.getSize();
            //�ж��ϴ��ļ���С
            if (size.compareTo(1024 * 1024L) > 0) {
                return error(model, url, "�����ϴ�����1M��ͼƬ��");
            }
            //�ϴ�ͼƬ
            UploadFileResult re = uploadManager.uploadImage(file, false,
                EnumImagePath.HOMEPAGE.getValue());
            if (re.isSuccess()) {
                hp.setAttachment(re.getFilePath());
                //ע�����Ա
                hp.setOperator(userAgernt.getLoginName());
                //�����ݿ��д洢
                Long id = homepagePicService.addHomepagePic(hp);
                if (id == null) {
                    //�ӷ�������ɾ��ͼƬ
                    uploadManager.deleteFile("", hp.getAttachment());
                    return error(model, url, "�����ݿ����ʧ��");
                } else {
                    return success(model, url, "��ӳɹ�");
                }
            } else {
                return error(model, url, "ͼƬ�ϴ�ʧ��");
                //				return error(model,re.getErrorCode(),re.getErrorMsg());
            }
        } catch (UploadFileException e) {
            return this.error(model, url, e.getMessage());
        }
    }

    /**
     * ɾ����ҳͼƬ
     * @param id
     * @param model
     * @param userAgernt
     * @return
     */
    @RequestMapping(value = "/homepage/pic/remove.htm")
    public String remove(@RequestParam("id") Long id, Model model, SystemUserAgent userAgernt) {
        HomepagePic hp = homepagePicService.getHomepagePicById(id);
        //ɾ��ͼƬ
        uploadManager.deleteFile("", hp.getAttachment());
        //ע�����Ա
        hp.setOperator(userAgernt.getLoginName());
        //�����ݿ���ɾ����¼
        Integer i = homepagePicService.removeHomepagePic(hp);
        String url = "/homepage/pic/list.htm";
        return i != null ? success(model, url, "ɾ���ɹ�") : error(model, url, "ɾ��ʧ��");
    }

    /**
     * �༭��ҳͼƬ
     * @param id
     * @param model
     * @param userAgernt
     * @return
     */
    @RequestMapping(value = "/homepage/pic/edit.htm", method = RequestMethod.GET)
    public String edit(@RequestParam("id") Long id, Model model, SystemUserAgent userAgernt) {
        HomepagePic hp = homepagePicService.getHomepagePicById(id);
        model.addAttribute("types", EnumHomePageType.values());
        model.addAttribute("homepic", hp);
        return "/homepage/pic/edit";
    }

    /**
     * �༭��ҳͼƬ
     * @param id
     * @param model
     * @param userAgernt
     * @return
     */
    @RequestMapping(value = "/homepage/pic/edit.htm", method = RequestMethod.POST)
    public String postEdit(@ModelAttribute("hp") HomepagePic hp, BindingResult result, Model model,
                           @RequestParam("file") MultipartFile file, SystemUserAgent userAgernt) {
        //���巵��Ŀ��
        String url = "/homepage/pic/list.htm";
        try {
            if (homepagePicService.getHomepagePicById(hp.getId()).getType()!=hp.getType()) {
                
            if (hp.getType() == 1) {
                if (homepagePicService.getPCHomepage().size()>=5) {
                    return error(model, url, "PC���Ѿ���5��ͼƬ,�����������");
                }
            } else if (hp.getType() == 2) {
                if (homepagePicService.getAPPHomepage().size()>=5) {
                    return error(model, url, "APP���Ѿ���5��ͼƬ,�����������");
                }
            } else if (hp.getType() == 3) {
                if (homepagePicService.getAPPStartHomepage().size()>=1) {
                    return error(model, url, "APP����ҳ���һ��ͼƬ,�����������");
                }
            } else {
                return error(model, url, "ͼƬ���ʹ���");
                }
            }
            Long size = file.getSize();
            if (size > 0) {

                //�ж��ϴ��ļ���С
                if (size.compareTo(1024 * 1024L) > 0) {
                    return error(model, url, "�����ϴ�����1M��ͼƬ��");
                }
                //�ϴ�ͼƬ
                UploadFileResult re = uploadManager.uploadImage(file, false,
                    EnumImagePath.HOMEPAGE.getValue());
                if (re.isSuccess()) {
                    hp.setAttachment(re.getFilePath());
                    //ע�����Ա
                    hp.setOperator(userAgernt.getLoginName());
                    //�����ݿ��д洢
                    Integer id = homepagePicService.updateHomepagePic(hp);
                    if (id == 0) {
                        //�ӷ�������ɾ��ͼƬ
                        uploadManager.deleteFile("", hp.getAttachment());
                        return error(model, url, "�����ݿ��޸�ʧ��");
                    } else {
                        return success(model, url, "�޸ĳɹ�");
                    }
                } else {
                    return error(model, url, "ͼƬ�ϴ�ʧ��");
                }
            } else {
                //ע�����Ա
                hp.setOperator(userAgernt.getLoginName());
                //�����ݿ��д洢
                Integer id = homepagePicService.updateHomepagePic(hp);
                if (id == 0) {
                    return error(model, url, "�����ݿ��޸�ʧ��");
                } else {
                    return success(model, url, "�޸ĳɹ�");
                }
            }
        } catch (UploadFileException e) {
            return this.error(model, url, e.getMessage());
        }
    }
}

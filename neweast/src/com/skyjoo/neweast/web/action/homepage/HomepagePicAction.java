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
 * 首页图片管理页面
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
     * 首页图片列表
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
     * 添加初始化
     * @param hp
     * @param result
     * @param model
     * @return
     */
    @RequestMapping(value = "/homepage/pic/add-init.htm")
    public String addInit(Model model) {
        if (homepagePicService.getHomepagePic().size() == 10) {
            return error(model, "/homepage/pic/list.htm", "已经10张图片,不能再添加了");
        }
        model.addAttribute("types", EnumHomePageType.values());
        return "/homepage/pic/add";
    }

    /**
     * 添加首页图片
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
        //定义返回目标
        String url = "/homepage/pic/list.htm";
        if (hp.getType() == 1) {
            if (homepagePicService.getPCHomepage().size()>=5) {
                return error(model, url, "PC端已经有5张图片,不能再添加了");
            }
        } else if (hp.getType() == 2) {
            if (homepagePicService.getAPPHomepage().size()>=5) {
                return error(model, url, "APP端已经有5张图片,不能再添加了");
            }
        }
        else if (hp.getType() == 3) {
            if (homepagePicService.getAPPStartHomepage().size()>=1) {
                return error(model, url, "APP开屏页最多一张图片,不能再添加了");
            }
        } else {
            return error(model, url, "图片类型错误");
        }
        //        if (homepagePicService.getHomepagePic().size() == 5) {
        //            return error(model, url, "已经5张图片,不能再添加了");
        //        }
        try {
            Long size = file.getSize();
            //判断上传文件大小
            if (size.compareTo(1024 * 1024L) > 0) {
                return error(model, url, "不能上传超过1M的图片！");
            }
            //上传图片
            UploadFileResult re = uploadManager.uploadImage(file, false,
                EnumImagePath.HOMEPAGE.getValue());
            if (re.isSuccess()) {
                hp.setAttachment(re.getFilePath());
                //注入操作员
                hp.setOperator(userAgernt.getLoginName());
                //向数据库中存储
                Long id = homepagePicService.addHomepagePic(hp);
                if (id == null) {
                    //从服务器上删除图片
                    uploadManager.deleteFile("", hp.getAttachment());
                    return error(model, url, "向数据库添加失败");
                } else {
                    return success(model, url, "添加成功");
                }
            } else {
                return error(model, url, "图片上传失败");
                //				return error(model,re.getErrorCode(),re.getErrorMsg());
            }
        } catch (UploadFileException e) {
            return this.error(model, url, e.getMessage());
        }
    }

    /**
     * 删除首页图片
     * @param id
     * @param model
     * @param userAgernt
     * @return
     */
    @RequestMapping(value = "/homepage/pic/remove.htm")
    public String remove(@RequestParam("id") Long id, Model model, SystemUserAgent userAgernt) {
        HomepagePic hp = homepagePicService.getHomepagePicById(id);
        //删除图片
        uploadManager.deleteFile("", hp.getAttachment());
        //注入操作员
        hp.setOperator(userAgernt.getLoginName());
        //从数据库中删除记录
        Integer i = homepagePicService.removeHomepagePic(hp);
        String url = "/homepage/pic/list.htm";
        return i != null ? success(model, url, "删除成功") : error(model, url, "删除失败");
    }

    /**
     * 编辑首页图片
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
     * 编辑首页图片
     * @param id
     * @param model
     * @param userAgernt
     * @return
     */
    @RequestMapping(value = "/homepage/pic/edit.htm", method = RequestMethod.POST)
    public String postEdit(@ModelAttribute("hp") HomepagePic hp, BindingResult result, Model model,
                           @RequestParam("file") MultipartFile file, SystemUserAgent userAgernt) {
        //定义返回目标
        String url = "/homepage/pic/list.htm";
        try {
            if (homepagePicService.getHomepagePicById(hp.getId()).getType()!=hp.getType()) {
                
            if (hp.getType() == 1) {
                if (homepagePicService.getPCHomepage().size()>=5) {
                    return error(model, url, "PC端已经有5张图片,不能再添加了");
                }
            } else if (hp.getType() == 2) {
                if (homepagePicService.getAPPHomepage().size()>=5) {
                    return error(model, url, "APP端已经有5张图片,不能再添加了");
                }
            } else if (hp.getType() == 3) {
                if (homepagePicService.getAPPStartHomepage().size()>=1) {
                    return error(model, url, "APP开屏页最多一张图片,不能再添加了");
                }
            } else {
                return error(model, url, "图片类型错误");
                }
            }
            Long size = file.getSize();
            if (size > 0) {

                //判断上传文件大小
                if (size.compareTo(1024 * 1024L) > 0) {
                    return error(model, url, "不能上传超过1M的图片！");
                }
                //上传图片
                UploadFileResult re = uploadManager.uploadImage(file, false,
                    EnumImagePath.HOMEPAGE.getValue());
                if (re.isSuccess()) {
                    hp.setAttachment(re.getFilePath());
                    //注入操作员
                    hp.setOperator(userAgernt.getLoginName());
                    //向数据库中存储
                    Integer id = homepagePicService.updateHomepagePic(hp);
                    if (id == 0) {
                        //从服务器上删除图片
                        uploadManager.deleteFile("", hp.getAttachment());
                        return error(model, url, "向数据库修改失败");
                    } else {
                        return success(model, url, "修改成功");
                    }
                } else {
                    return error(model, url, "图片上传失败");
                }
            } else {
                //注入操作员
                hp.setOperator(userAgernt.getLoginName());
                //向数据库中存储
                Integer id = homepagePicService.updateHomepagePic(hp);
                if (id == 0) {
                    return error(model, url, "向数据库修改失败");
                } else {
                    return success(model, url, "修改成功");
                }
            }
        } catch (UploadFileException e) {
            return this.error(model, url, e.getMessage());
        }
    }
}

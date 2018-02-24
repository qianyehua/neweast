package com.skyjoo.neweast.web.action.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skyjoo.neweast.biz.app.domain.VersionInfo;
import com.skyjoo.neweast.biz.app.service.VersionService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.validator.VersionValidator;

/**
 * 版本管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/app/version")
public class VersionAction extends BaseAction {
    @Autowired
    private VersionService versionService;
    @Autowired
    private VersionValidator versionValidator;
    
    @RequestMapping("/list.htm")
    public String versionList(Model model) {
        model.addAttribute("versionList",versionService.getVersionList());
        
        return "app/version/list";
    }
    
    @RequestMapping(value="/edit-init.htm",method = RequestMethod.GET)
    public String getVersionInfo(@RequestParam("id")Long id,Model model) {
        VersionInfo versionInfo = versionService.getVersionById(id);
        
        if(versionInfo == null){
            model.addAttribute("message","找不到对应的版本！");
            model.addAttribute("url","/app/version/list.htm");
            return "error";
        }
        
        model.addAttribute("versionInfo",versionInfo);
        
        return "app/version/edit";
    }
    
    @RequestMapping(value="/edit.htm",method = RequestMethod.POST)
    public String updateVersion(VersionInfo versionInfo,BindingResult result,Model model) {
        versionValidator.validate(versionInfo, result);
        if (result.hasErrors()) {
            return "app/version/edit";
        }
        
        Integer res = versionService.updateVersion(versionInfo);
        if (res < 0) {
            model.addAttribute("errorMessage", "更新失败");
            return redirect("/app/version/edit-init.htm?id=" + versionInfo.getId());
        }

        return success(model, "/app/version/list.htm", "更新成功");
    }
}

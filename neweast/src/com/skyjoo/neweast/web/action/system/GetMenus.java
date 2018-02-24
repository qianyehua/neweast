/**
 * 
 */
package com.skyjoo.neweast.web.action.system;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eyeieye.melos.util.StringUtil;
import com.skyjoo.neweast.biz.system.domain.SystemFunction;
import com.skyjoo.neweast.biz.system.service.SystemFunctionService;
import com.skyjoo.neweast.web.action.BaseAction;

/**
 * @author wangming
 *
 */
@Controller
public class GetMenus extends BaseAction {
	
	@Autowired
	private SystemFunctionService systemFunctionService;
	
	@RequestMapping(value = "getMenus.htm", method = RequestMethod.POST)
	public void getMenus(HttpServletRequest request, HttpServletResponse response){
		String pid  =request.getParameter("pid");
		String id = request.getParameter("id");
		JSONArray menus = new JSONArray();
		if(StringUtil.isNotBlank(pid) && NumberUtils.isDigits(pid)){
			SystemFunction menu = systemFunctionService.getSystemFunctionById(Long.parseLong(pid));
			JSONObject json = new JSONObject();
			json.accumulate("url", menu.getUrl());
			json.accumulate("name", menu.getName());
			menus.add(json);
		}
		if(StringUtil.isNotBlank(id) && NumberUtils.isDigits(id)){
			SystemFunction menu = systemFunctionService.getSystemFunctionById(Long.parseLong(id));
			JSONObject json = new JSONObject();
			json.accumulate("url", menu.getUrl());
			json.accumulate("name", menu.getName());
			menus.add(json);
		}
		PrintWriter out = null;
        response.setContentType("text/xml; charset=UTF-8");
        try {
            out = response.getWriter();
        } catch (IOException e) {
            logger.error("GetMenus.getMenus", e);
        }
        out.write(menus.toString());
        out.flush();
        out.close();
	}
}

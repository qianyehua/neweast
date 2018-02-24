package com.skyjoo.neweast.web.action.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skyjoo.neweast.biz.test.domain.test;
import com.skyjoo.neweast.biz.test.service.TestService;

@Controller
@RequestMapping("/test")
public class TestAction {
    
	@Autowired
	private TestService testservice;
	
	@RequestMapping("/test_list.htm")
	public String list(test list,Model model){
		Long id=list.getId();
		if(id!=null){
			list.setId(id);
		}
		 list=(test)testservice.list(list);
		model.addAttribute("list", list);
		return "test/list";
	}
	
	@RequestMapping("/add_list.htm")
	public String add_list(){
		return "test/add_list";		
	}
	
	@RequestMapping("/add.htm")
	public String add(@ModelAttribute test tt){
		boolean flag=testservice.add(tt);
		
	return flag==true ? "success":"error";
	}
	
	
	@RequestMapping("/edit_list.htm")
	public String edit_list(@RequestParam("id") Long id,Model model){
		test t=testservice.obje(id);
		model.addAttribute("test", t);
		return "test/edit_list";
	}
	
	@RequestMapping("/edit.htm")
	public String edit(@ModelAttribute test tt){
	   boolean	flag=testservice.update(tt);
		return  flag==true ? "success":"error";
	}
	
	@RequestMapping("/delet.htm")
	public String delet(@RequestParam("id") Long id){
		boolean flag = testservice.remove(id);
		
		return flag==true? "success":"error";
	}
}

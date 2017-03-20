package com.trajectory.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trajectory.service.ITestService;

@Controller  
@RequestMapping("/test")
public class TestController {
	
	@Resource
	private ITestService testService;
	
	@RequestMapping("/showTest")
	public String toIndex(HttpServletRequest request, Model model){
		int id = Integer.parseInt(request.getParameter("id"));
		com.trajectory.pojo.Test test = this.testService.getTestById(id);
		model.addAttribute("test", test);
		return "showTest";
	}

}

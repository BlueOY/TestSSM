package com.trajectory.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.trajectory.pojo.Test;
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
	
	@RequestMapping("/testJson")
	public void testJson(HttpServletRequest request, PrintWriter out){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("key", "value");
		out.write(jsonObject.toJSONString());
	}
	
	@RequestMapping("/testObject")
	@ResponseBody
	public com.trajectory.pojo.Test testObject(HttpServletRequest request){
		com.trajectory.pojo.Test test = new com.trajectory.pojo.Test();
		test.setId(1);
		test.setName("name");
		return test;
	}

}

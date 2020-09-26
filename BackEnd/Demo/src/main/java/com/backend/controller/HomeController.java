package com.backend.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String getHome(Model model) {
		logger.info("HomeController is called");
		model.addAttribute("main_page", "VisualUp 메인 페이지입니다" );
		
		return "/home/home";
	}
	
	@RequestMapping(value = "/", method=RequestMethod.GET, params="userid")
	public String getUserHome(@RequestParam("userid") String userid, Model model) {
		logger.info("HomeController is called");
		model.addAttribute("user_page", "사용자 "+userid+"의 메인 페이지입니다" );
		return "/home/userhome";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String loginHome(Model model) {
		
		
		RequestLogin requestLogin = new RequestLogin();
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("github", requestLogin.requestGithub());
		map.put("google", requestLogin.requestGoogle());
		map.put("kakao",requestLogin.requestKakao());
		
		

		model.addAttribute("loginURL", map);
	
		return "/login/loginHome";
	}
	
	
	
}
package com.mycompany.myapp.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")    //   '/'앞에 local 저장소 주소 있느거임!!
	public String home() {
		
		//개발 다 하고 log 다 지워줄것!!!
		//System.out.println("HomeController-home()");
		//아래 debug써주면 출력은 안되지만, 나중에 오류생겨서 명령어 하나 쓰면 어디서잘못 됫는지알려줌!
		//logger.debug("HomeController-home()");
		

		//console 창에 실행됨
		logger.info("HomeController-home()");
		
		return "home";
	}
	
}

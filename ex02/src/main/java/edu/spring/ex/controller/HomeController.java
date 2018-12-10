package edu.spring.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller 콤포넌트임을 정의(설정)
// -> 콘트롤러를 생성하기 위해서는 bean 설정 -> 서블릿 컨텍스트(mvc-config.xml)에서 설정
// -> 서블릿 컨텍스트(mvc-config.xml)에서 설정
@Controller
public class HomeController {

	@RequestMapping (value = "/")
	public String home() {
		return "main";
	}
	
}

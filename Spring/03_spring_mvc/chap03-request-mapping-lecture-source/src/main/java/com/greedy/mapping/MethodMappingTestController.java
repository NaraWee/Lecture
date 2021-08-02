package com.greedy.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * DispatcherServlet은 웹 요청을 받는 즉시 @Controller가 달린 컨트롤러 클래스에 처리를 위임한다.
 * 그 과정은 컨트롤러 클래스의 핸드러 메소드에 선언된 다양한 @ReqeustMapping 설정 내용에 따른다.
 */
@Controller
public class MethodMappingTestController {

	/* 1. 메소드에 요청 매핑하기 */
	/* RequestMapping 설정에 method 방식을 지정하지 않으면 get/post 요청 둘 다 처리한다. */
	@RequestMapping("/menu/regist")
	public String registMenu(Model model) {
		
		model.addAttribute("message","신규 메뉴 등록용 메소드 호출함");
		
		return "mappingResult";
	}
	
	@RequestMapping(value="/menu/modify", method = RequestMethod.GET)
	public String modifyMenu(Model model) {
		model.addAttribute("message","GET 방식의 메뉴 수정용 핸들러 메소드 호출함");
		
		return "mappingResult";
	}
	
	/*
	 * 요청 메소드 별 전용 어노테이션(since 4.3)
	 * 핸들러 메소드를 조금 더 간결하게 코딩할 수 있게 해준다.
	 * 요청 메소드		어노테이션
	 * POST			@PostMapping			Insert 쓸 떄?
	 * GET			@GetMapping				Select 쓸 떄
	 * DELETE		@DeleteMapping			Delete 쓸 떄
	 * PUT			@PutMapping				Update 쓸 떄
	 */
	
	@GetMapping("/menu/delete")
	public String getDeleteMenu(Model model) {
		model.addAttribute("message","GET 방식의 메뉴 삭제용 핸들러 메소드 호출함");
		
		return "mappingResult";
	}
	
	@PostMapping("/menu/delete")
	public String postDeleteMenu(Model model) {
		model.addAttribute("message","POST 방식의 메뉴 삭제용 핸들러 메소드 호출함");
		
		return "mappingResult";
	}
}

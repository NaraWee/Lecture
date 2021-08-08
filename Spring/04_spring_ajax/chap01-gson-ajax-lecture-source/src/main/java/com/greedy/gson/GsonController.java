package com.greedy.gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class GsonController {
	
	private final List<MemberDTO> memberList;
	
	public GsonController() {
		memberList = new ArrayList<>();
		memberList.add(new MemberDTO(1,"홍길동",20,new java.sql.Date(System.currentTimeMillis())));
		memberList.add(new MemberDTO(2,"유관순",16,new java.sql.Date(System.currentTimeMillis())));
		memberList.add(new MemberDTO(3,"이순신",40,new java.sql.Date(System.currentTimeMillis())));
		memberList.add(new MemberDTO(4,"윤봉길",30,new java.sql.Date(System.currentTimeMillis())));
	}
	
	/* 1. stream을 이용한 방식 */
	@GetMapping("gson1")
	public void getMemberList(HttpServletResponse response) throws IOException {
		
		response.setContentType("application/json; charset=UTF-8");
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd hh:mm:ss:SSS")
				.setPrettyPrinting()								// json문자열을 예쁘게 출력해준다.
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)	// 기본값
				.serializeNulls()									// 필드값이 null이어도 직렬화한다.
				.disableHtmlEscaping()								// 직렬화시 escape 시퀀스처리 하지 않는다. <h1>홍<h1>
				.create();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(memberList));
		
		out.flush();
		out.close();
	}
	
	/* 2. @ResponseBody를 이용한 방법
	 * 스프링 3.2 이후 버전 @ResponseBody 어노테이션을 이용하면 contentType 설정을 produces 속성에 명시해야한다.
	 */
	@GetMapping(value="gson2",produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getMemberListOnResponseBody() {
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd hh:mm:ss:SSS")
				.setPrettyPrinting()								// json문자열을 예쁘게 출력해준다.
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)	// 기본값
				.serializeNulls()									// 필드값이 null이어도 직렬화한다.
				.disableHtmlEscaping()								// 직렬화시 escape 시퀀스처리 하지 않는다. <h1>홍<h1>
				.create();
		
		return gson.toJson(memberList); 
	}
	
	/*
	 * 3. jsonView를 이용하여 ModelAndView 반환하는 방법
	 * 	    전송하려는 객체를 ModelAndView에 담고 view 이름을 jsonView로 설정하여 반환한다.
	 *    jsonView라는 이름의 bean이 존재하는 경우 jsp응답이 아닌 json으로 응답할 수 있는 뷰 리졸버를 이용하는 방식이다.
	 */
	@GetMapping(value="gson3")
	public ModelAndView getMemberListInModelAndView(ModelAndView mv, HttpServletResponse response) {
		
		response.setContentType("application/json; charset=UTF-8");
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd hh:mm:ss:SSS")
				.setPrettyPrinting()								// json문자열을 예쁘게 출력해준다.
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)	// 기본값
				.serializeNulls()									// 필드값이 null이어도 직렬화한다.
				.disableHtmlEscaping()								// 직렬화시 escape 시퀀스처리 하지 않는다. <h1>홍<h1>
				.create();

		mv.addObject("memberList", gson.toJson(memberList));
		mv.setViewName("jsonView");
		
		return mv;
	}
}

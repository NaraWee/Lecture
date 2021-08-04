package com.greedy.resolver;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/*")
public class ResolverController {

	@GetMapping("string")
	public String stringReturning(Model model) {
		
		model.addAttribute("message","문자열로 뷰 이름 반환한다.");
		
		return "result";
	}
	
	@GetMapping("string-redirect")
	public String stringRedirect(Model model) throws UnsupportedEncodingException {
		
		model.addAttribute("message",URLEncoder.encode("문자열로 뷰 이름 반환하며 리다이렉트", "UTF-8"));
		
		/* 접두사로 redirect:을 하면 forward가 아닌 redirect 시킨다.*/
		return "redirect:main";
	}
	
	@GetMapping("string-redirect-attr")
	public String stringRedirectFlashAttribute(RedirectAttributes rttr) {
		/*
		 * 리다이렉트 시 url에 노출되지 않는 정보를 flash영역에 한번만 담아서 redirect를 할 수 있다.
		 * 자동 모델에 추가되기 때문에 requestScope에서 값을 꺼내서 사용하면 된다.
		 * 게견에 임시로 값을 담고 소멸하는 방식이기 때문에 session에 동일한 키값이 존재하지 않아야 한다.
		 */
		
		rttr.addFlashAttribute("flashMessage","리다이렉트 attr 사용하여 redirect");
		
		return "redirect:main";
		
	}
	
	@GetMapping("modelandview")
	public ModelAndView modelAndViewReturning(ModelAndView mv) {
		
		/*
		 * 모델과 뷰를 합친 개념이다.
		 * 핸들러 어댑터가 핸들러 메소드를 호출하고 반환받은 문자열을 ModelAndView로 만드러 dispatcherServlet에 반환한다.
		 * 이때 문자열을 반환해도 되지만 ModelAndView를 미리 만들어서 반환할 수 있다.
		 */
		
		mv.addObject("message","ModelAndView를 이용한 모델과 뷰 반환");
		mv.setViewName("result");
		
		return mv;
	}
	
	@GetMapping("modelandview-redirect")
	public ModelAndView modelAndViewRedirect(ModelAndView mv) throws UnsupportedEncodingException {
		
		mv.addObject("message1",URLEncoder.encode("ModelAndView를 이용한 redirect","UTF-8"));
		mv.setViewName("redirect:main");
		
		return mv;
	}
	
	@GetMapping("modelandview-redirect-attr")
	public ModelAndView modelAndViewRedirect(ModelAndView mv, RedirectAttributes rttr) {
		
		rttr.addFlashAttribute("flashMessage1", "ModelAndView를 이용한 redirect");
		mv.setViewName("redirect:main");
		return mv;
	}
}

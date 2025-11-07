package com.yedam.sample.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;


@Log4j2
@Controller
@RequestMapping("/sample/*")		// 	/sample/
public class SampleController {
	@GetMapping("/success")
	public String success() {
		return "success";
	}
	
	@RequestMapping(value ={"insert", "/"}, method = {RequestMethod.POST,RequestMethod.GET})
	public void basic() {
//		System.out.println("basic....");
		log.info("basic....");
	}
	
	@GetMapping("/ex01")	//	/ex01?name=aaa&age=15
	public String ex01(SampleDTO sample, RedirectAttributes ra) {
		log.info("sampleDTO : "+sample);
		ra.addFlashAttribute("msg","가입축하!");
		ra.addAttribute("name", sample.getName());
		return "redirect:/sample/success";
		
	}
	
	@GetMapping("/ex02") 		//ex02?name=aaa&age=20
	public String ex02(@RequestParam("name") String name
					 , @RequestParam(defaultValue = "20", value="age", required=false) int age) {
		log.info(name + " : " + age);
		return "ex02";
	}
	
	@GetMapping("/ex02Array")	// ex02Array?ids=3&ids=5&ids=10		//보통 체크박스에서 사용
	public void ex02Array(@RequestParam("ids") List<String>ids ) {
		log.info("ids : " + ids);
	}
	
	@GetMapping("/ex03")
	public ModelAndView ex03(@RequestParam String param) {
		ModelAndView mv = new ModelAndView("/hello", "greet","hi");
//		mv.setViewName("/hello");
//		mv.addObject("greet", "hi");
		return mv;
	}
	
	
}

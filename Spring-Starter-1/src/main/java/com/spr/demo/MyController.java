package com.spr.demo;

import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.stereotype.Controller;  
@Controller
public class MyController {
@RequestMapping("/")
public String index() {
	return "index";
	
}
@RequestMapping("/hello")
public String test() {
	return "hello";	
}
@RequestMapping("/loadForm")
public String form() {
	return "myForm";
	
}
@RequestMapping(value="/save", method=RequestMethod.POST)  
public ModelAndView save(@ModelAttribute User user){  
    ModelAndView modelAndView = new ModelAndView();  
modelAndView.setViewName("validate");      
modelAndView.addObject("user", user);    
return modelAndView;  
}  
}

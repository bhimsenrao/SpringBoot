package com.spr.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SprJdbcControl {
@Autowired JdbcTemplate jdbc;
@RequestMapping("/loadForm")
public String form() {
	return "myForm";
	
}
@RequestMapping(value="/save", method=RequestMethod.POST)  
public ModelAndView save(@ModelAttribute Person person){  
    ModelAndView modelAndView = new ModelAndView();  
modelAndView.setViewName("validate");      
modelAndView.addObject("user", person);    
jdbc.execute("insert into person values("+person.getId()+",'"+person.getPname()+"')");
//jdbc.execute("insert into user(name,email)values('javatpoint','java@javatpoint.com')");  

return modelAndView;  
}  
}

package com.saiproject.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {
	
	  RestTemplate rt = new RestTemplate();  
	  
	  @RequestMapping("/login")
	  public ModelAndView index () { 
		  ModelAndView  modelAndView = new ModelAndView(); 
		  modelAndView.setViewName("login.html");
	      return modelAndView;
	  }
	  
	  @RequestMapping("/login/abc")
	  public String sai (User user) {
		  int c=0,i=0;
		  String us1 = user.getUsername();
		  String p1 = user.getPassword();
		  String temp=null;
		 
		  if(c++==0)
		   temp = rt.getForObject("http://localhost:8081/hii", String.class);
		   String[] strArr = temp.split(",");
		  while(i<strArr.length)
		  {
			  String us2 =strArr[i++];	    	  
	    	  String p2 =strArr[i++];
	    	  if(us1.equals(us2)&&p1.equals(p2))
		    	{
		    		 return "success";
		    	}
		  }
		  i=0;
		  
	      
	      return "fail";
		  
	      
	  
	
}
}
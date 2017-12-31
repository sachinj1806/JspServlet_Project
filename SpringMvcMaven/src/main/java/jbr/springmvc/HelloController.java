package jbr.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.service.AddService;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView hello() {
		System.out.println("********* Inside HelloController");
		return new ModelAndView("welcome", "message", "Welcome to Spring MVC using Maven!!!");
	}
	
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest req,HttpServletResponse res) {
		
		System.out.println("******* Inside AddController *******");

		int i=Integer.parseInt(req.getParameter("tb1"));
		int j=Integer.parseInt(req.getParameter("tb2"));
		
		AddService as=new AddService();
		
		//int k=i+j;
		
		int k=as.add(i, j);
		
		System.out.println("******* k :: = " + k );
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display");
		mv.addObject("Sujata",k);
		
		
		return mv;

	}
}

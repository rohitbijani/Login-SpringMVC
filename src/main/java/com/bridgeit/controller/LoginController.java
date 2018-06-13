package com.bridgeit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.model.Login;
import com.bridgeit.model.User;
import com.bridgeit.service.UserService;

@Controller
public class LoginController {
	
	 @Autowired
	  UserService userService;
	 
	 @RequestMapping(value = "/", method = RequestMethod.GET)
		public String home() {
			
			return "login";
		}
	 
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("login") Login login) {
	    ModelAndView mav = null;
	    User user = userService.validateUser(login);
	    
	    if (user!= null) {
	    	HttpSession session=request.getSession();
			session.setAttribute("username", user.getUsername());			
	    	mav=new ModelAndView("redirect:/loginSuccess");
	    } 
	    else {
	    mav = new ModelAndView("login");
	    mav.addObject("message", "Username or Password is wrong!!");
	    }
	    return mav;
	  }
	
	@RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
	private ModelAndView success(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = null;
    	HttpSession session=request.getSession(false);
    	
    	if (session!=null) {
    		mav = new ModelAndView("welcome");
    	    mav.addObject("username", session.getAttribute("username"));
		}
    	else {
    		mav = new ModelAndView("login");
    		
		}
    	
	    
		return mav;

	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession(false);
		if(session != null) {
			session.removeAttribute("username");
			session.invalidate();
			
		}
		return "login";
	}

}

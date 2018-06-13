package com.bridgeit.interceptor;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class RegistrationInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uname=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		Pattern pattern= Pattern.compile("^([a-zA-Z0-9])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,4})+$");
		
		ModelAndView mav=new ModelAndView("registration");
		mav.addObject("uname", uname);
		mav.addObject("pwd", password);
		mav.addObject("email", email);
		mav.addObject("phone", phone);
		
		if(uname=="" || password=="" || phone=="") {	
			if (uname==null || uname==""){
				mav.addObject("msg", "Username can't be blank");
			}
			else if(password.length()<6){  
				mav.addObject("msg", "Password must be at least 6 characters long");
			}
			else if (phone=="") {
				mav.addObject("msg", "Phone can't be blank");
			}
			
			throw new ModelAndViewDefiningException(mav);
		}

		else if(!pattern.matcher(email).matches()){
			mav.addObject("msg", "Invalid email format");
			throw new ModelAndViewDefiningException(mav);
		}
		
		return true;
	}
	
}

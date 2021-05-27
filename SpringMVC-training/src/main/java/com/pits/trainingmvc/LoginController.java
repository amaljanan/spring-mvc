package com.pits.trainingmvc;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pits.trainingmvc.model.User;
import com.pits.trainingmvc.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView modelandview = new ModelAndView();
		
		HttpSession session = request.getSession();
		
		String username = (String) session.getAttribute("username");
		
		if(username != null && username.contains("@")) {
			modelandview.setViewName("AdminUser.jsp");
			modelandview.addObject("username", username.split("\\@")[0]);
		}
		else if(username != null)
		{
			modelandview.setViewName("NormalUser.jsp");
			modelandview.addObject("username", username);
			
		}
		else
			modelandview.setViewName("index.jsp");

		return modelandview;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ModelAndView loginCheck(@RequestParam("username") String username,
			@RequestParam("password") String password,HttpServletRequest request) {
		
			ModelAndView modelandview = new ModelAndView();
		
			HttpSession session = request.getSession();		
			session.setAttribute("username", username);
			
			User user = new User();
			user = loginService.logincheck(username, password);
		if(user ==null)
		{
			modelandview.setViewName("index.jsp");
			modelandview.addObject("errorMessage", "Wrong username or Password!!!");
		}
		else if (user.getRole() ==1) {
			
			
			modelandview.setViewName("AdminUser.jsp");
			modelandview.addObject("username", username.split("\\@")[0]);
		} 
		else if (user.getRole() ==0) {
			
			modelandview.setViewName("NormalUser.jsp");
			modelandview.addObject("username", username);
		}

		else {
			modelandview.setViewName("index.jsp");
			modelandview.addObject("errorMessage", "Wrong username or Password!!!");
		}
		

		return modelandview;
	}
}

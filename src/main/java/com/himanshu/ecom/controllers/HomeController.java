package com.himanshu.ecom.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.himanshu.ecom.dao.UserDAO;
import com.himanshu.ecom.entity.User;

@Controller
public class HomeController {
	
	
	@Autowired
	private UserDAO userdao;
	
	HttpServletRequest httpServletRequest;
	

	@RequestMapping("/")

	public String login(@ModelAttribute("userLogin")User user)
	{
		
		return "login";
	}
	@RequestMapping("/home")
	public String home(@ModelAttribute("userLogin")User user)
	{
		
		return "home";
	}
	@RequestMapping("/loginPage")
	public String loginPage(@Valid @ModelAttribute("userLogin")User user, BindingResult result)
	{
		
			if(userdao.findUser(user.getEmail(), user.getPassword()))
			{
				return "home";
			}
			
			return "login";
	}
	
	@RequestMapping("/register")
	public String register(@Valid @ModelAttribute("userReg") User user, BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println("Error found");
			
			List<ObjectError> allError= result.getAllErrors();
			
			for(ObjectError error:allError)
			{
				System.out.println(error);
			}
			
			return "register";
		}
		return "register";
	}
	
	@RequestMapping("/registerPage")
	public String registerPage(@Valid @ModelAttribute("userReg") User user, BindingResult result)
	{
		
		if(result.hasErrors())
		{
			System.out.println("Error found");
			
			List<ObjectError> allError= result.getAllErrors();
			
			for(ObjectError error:allError)
			{
				System.out.println(error);
			}
			
			return "register";
		}
			
		userdao.saveUser(user);
	
		//HttpSession session1=httpServletRequest.getSession();
		 // session1.setAttribute("currentUserID", user.getId());
		
	//	System.out.println("setting session in reg.  " + session1.getAttribute("currentUserID"));
		
		System.out.println(user.toString());
		
		return "home";
	}
	@RequestMapping("/logout")
	public String logOut()
	{
		return "redirect:/";
	}
	
}

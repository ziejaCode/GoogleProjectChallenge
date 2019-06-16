package com.ziejacode.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ziejacode.model.User;
import com.ziejacode.services.UserService;


@Controller
public class HomeController {
	
private final UserService userService;    
	
    public HomeController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping({"/","" })
	public  String showWelcomePage(){		
		return "index";		
	}	
	
	@GetMapping
    @RequestMapping("/user/showUser")
    public String getIndividualUser( Model model ) {
    	
		int id = 1;		
    	model.addAttribute("user", userService.getUserByUserId(id));
    	return "user/showUser";
    }
	
	@GetMapping
    @RequestMapping("/user/{id}/update")
    public String updateUser(@PathVariable Integer id, Model model) {
    	
    	User userToUpdate = userService.getUserByUserId(id);
    	model.addAttribute("user", userToUpdate);
    	return "user/updateUser";
    } 
    
    @PostMapping
    @RequestMapping("updateUser")
    public String updateUser(@ModelAttribute User user) {
    	
    	user = userService.updateUser(user);  
    	//return "redirect:/user/" + user.getUserId() + "/showUser/";   
    	return "redirect:/user/showUser/";
    }
	
	
	
}

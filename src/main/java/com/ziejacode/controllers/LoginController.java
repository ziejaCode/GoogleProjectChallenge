package com.ziejacode.controllers;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ziejacode.model.User;
import com.ziejacode.services.UserService;



//@Controller
public class LoginController {

	private final UserService userService;    
	
    public LoginController(UserService userService) {
		this.userService = userService;
	}
    
    
    // User presentation methods
    
    @GetMapping
    @RequestMapping("/user/showUsers")
    public String getAllUsers(Model model) {	
    	
    	model.addAttribute("users", userService.getAllUsers());    	
		return "user/showUsers";
	}    
    
    @GetMapping
    @RequestMapping("/user/{id}/showUser")
    public String getIndividualUser(@PathVariable Integer id,  Model model ) {
    	
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
    	return "redirect:/user/" + user.getUserId() + "/showUser/";     	
    }
    
    
    @GetMapping
    @RequestMapping("user/{id}/deleteById")
    public String deleteUserById(@PathVariable Integer id) {
    	//System.out.println("User to delete is " + id); 
    	userService.deleteByUserId(id);    	
    	return "redirect:/user/showUsers";
    }
    
	
}
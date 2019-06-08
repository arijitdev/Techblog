package com.arijit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arijit.model.Post;
import com.arijit.model.User;
import com.arijit.model.UserProfile;
import com.arijit.service.PostService;
import com.arijit.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private PostService postservice;
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping("users/login")
	public String login() {
		return "users/login";
	}
	
	@RequestMapping(value="users/login",method=RequestMethod.POST)
	public String loginUser(User user,HttpSession session) {
		User existingUser=userservice.login(user);
        if(existingUser!=null) {
        	session.setAttribute("Loggeduser", existingUser);
            return "redirect:/posts";
        }
        else {
            return "users/login";
        }
    }
	
	@RequestMapping(value="users/logout",method=RequestMethod.POST)
	public String logout(Model model,HttpSession session) {
		
		session.invalidate();
		List<Post> posts = postservice.getAllPosts();
		model.addAttribute("posts", posts);
		return "index";
	}
	
	@RequestMapping("users/registration")
	public String registration(Model model) {
	   User user = new User();
	   UserProfile profile = new UserProfile();
	   user.setProfile(profile);

	   model.addAttribute("User", user);

	   return "users/registration";
	}
	
	@RequestMapping(value = "users/registration", method = RequestMethod.POST)
	public String registerUser(User user) {
		userservice.registerUser(user);
	   return "users/login";
	}
	
}

package com.arijit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arijit.model.Post;
import com.arijit.service.PostService;

@Controller
public class HomeController {
	
	@Autowired
	PostService postservice;
	
	@RequestMapping("/")
	public String getAllPosts(Model model) {
		
	    List<Post> posts = postservice.getAllPosts();
		model.addAttribute("posts",posts);
		
		return "index";
	}

}

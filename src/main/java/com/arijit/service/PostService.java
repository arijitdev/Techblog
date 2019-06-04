package com.arijit.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arijit.model.Post;
import com.arijit.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public List<Post> getAllPosts(){

		return repository.getAllPosts();
	}
	
	
	public Post getOnePost(){
		
		return repository.getLatestPost();
	}


	public void createPost(Post newPost) {
		
		repository.createPost(newPost);
		System.out.println("New Post:"+newPost);
		
	}
	
	public Post getPost(Integer postId) {
		
		return repository.getPost(postId);
	
	}
}

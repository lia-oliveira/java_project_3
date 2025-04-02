package com.oliveiralia.api_blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveiralia.api_blog.domain.Post;
import com.oliveiralia.api_blog.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Post user = repo.findById(id).orElseThrow(() ->new ObjectNotFoundException("Objeto não encontrado"));
		return user;
	}

}

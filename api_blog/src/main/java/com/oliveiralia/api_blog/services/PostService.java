package com.oliveiralia.api_blog.services;

import java.util.Date;
import java.util.List;

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
	//query 
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
	public List<Post> searchPostByIntervalDate(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.searchPostByIntervalDate(text, minDate, maxDate);
	}
	
	//query methods
	//public List<Post> findByTitle(String text) {
		//return repo.findByTitleContainingIgnoreCase(text);
	//}

}

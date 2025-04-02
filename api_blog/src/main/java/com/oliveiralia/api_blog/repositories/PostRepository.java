package com.oliveiralia.api_blog.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.oliveiralia.api_blog.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	//Query methods
	List<Post> findByTitleContainingIgnoreCase(String text);

}

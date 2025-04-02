package com.oliveiralia.api_blog.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.oliveiralia.api_blog.domain.Post;
import com.oliveiralia.api_blog.domain.User;
import com.oliveiralia.api_blog.dto.AuthorDTO;
import com.oliveiralia.api_blog.repositories.PostRepository;
import com.oliveiralia.api_blog.repositories.UserRepository;

@Configuration
public class Instanciation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Título do Post 1", "Conteúdo do post 1", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Título do Post 2", "Conteúdo do post 2", new AuthorDTO(maria));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}

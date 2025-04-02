package com.oliveiralia.api_blog.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oliveiralia.api_blog.domain.Post;
import com.oliveiralia.api_blog.resources.util.URL;
import com.oliveiralia.api_blog.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	/* No Java Moderno quando o @RequestParam receber um prâmetro já informado no método, não é necessário colocá-lo explicitamente.
	  Basta colocar o valor default caso haja. Caso o parâmetro não tivesse sido passado como argumento do método
	  seria necessário inserí-lo na anotação. findByTitle(@RequestParam(value="blblabla", defaultValue="") String text)
	 */
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(defaultValue="") String text){
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/searchPostByIntervalDate")
	public ResponseEntity<List<Post>> searchPostByIntervalDate(
			@RequestParam(defaultValue="") String text,
			@RequestParam(defaultValue="") String minDate,
			@RequestParam(defaultValue="") String maxDate
			) {
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = service.searchPostByIntervalDate(text, min, max);
		return ResponseEntity.ok().body(list);
		
	} 

}

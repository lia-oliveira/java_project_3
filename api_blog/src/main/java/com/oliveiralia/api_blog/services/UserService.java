package com.oliveiralia.api_blog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveiralia.api_blog.domain.User;
import com.oliveiralia.api_blog.dto.UserDTO;
import com.oliveiralia.api_blog.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		User user = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
		return user;
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = repo.findById(obj.getId()).orElseThrow(() -> new RuntimeException("User not found"));;
		updateData(newObj, obj);
		return repo.save(newObj);		
	}

	private void updateData(User newObj, User objDto) {
		newObj.setName(objDto.getName());
		newObj.setEmail(objDto.getEmail());
	}

}

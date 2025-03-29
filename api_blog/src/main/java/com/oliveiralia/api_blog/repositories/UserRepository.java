package com.oliveiralia.api_blog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.oliveiralia.api_blog.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}

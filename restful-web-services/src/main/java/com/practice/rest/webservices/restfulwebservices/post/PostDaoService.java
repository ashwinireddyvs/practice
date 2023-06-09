package com.practice.rest.webservices.restfulwebservices.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class PostDaoService {
	
	@Autowired
	private PostRepository repository;

	public Post savePost(@Valid Post post) {
		// TODO Auto-generated method stub
		return repository.save(post);
	}
	
	
	
}

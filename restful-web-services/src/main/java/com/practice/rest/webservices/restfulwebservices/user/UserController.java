package com.practice.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practice.rest.webservices.restfulwebservices.post.Post;
import com.practice.rest.webservices.restfulwebservices.post.PostDaoService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import jakarta.validation.Valid;

@RestController
public class UserController {
		
		@Autowired
		private UserDaoService userService;
		
		@Autowired
		private PostDaoService postService;
		
		
		@GetMapping("/users")
		public List<User> reteiveAllUsers(){
			
			return userService.retriveAllUsers();
		}
		
		@GetMapping("/users/{id}")
		public EntityModel<User> retUserById(@PathVariable int id) {
			
			User user = userService.retriveUserById(id);
			EntityModel<User> entityModel = EntityModel.of(user);
			
			WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).reteiveAllUsers());
			entityModel.add(link.withRel("all-users"));
			
			return entityModel;
		}
		
		@PostMapping("/users")
		public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
			User savedUser = userService.createUser(user);
			
			URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
			ResponseEntity<User> responseEntity = ResponseEntity.created(location ).build();
			
			return responseEntity;
		}
	
		@DeleteMapping("/users/{id}")
		public void deleteUserById(@PathVariable int id) {
			 userService.deletUserByID(id);
		}
		
		@GetMapping("/users/{id}/posts")
		public List<Post> retrivePostsForUser(@PathVariable int id){
			return userService.retrivePostsForUser(id);
		}
		
		@PostMapping("/users/{id}/posts")
		public ResponseEntity<User> createPostForUser(@Valid @RequestBody Post post,@PathVariable int id) {
			User user = userService.retriveUserById(id);
			post.setUser(user);
			Post savedPost = postService.savePost(post);
			
			URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedPost.getId())
						.toUri();
			ResponseEntity<User> requestEntity = ResponseEntity.created(location ).build();
			
			return requestEntity;
		}
		
		
}

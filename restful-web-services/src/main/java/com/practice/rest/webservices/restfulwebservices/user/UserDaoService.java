package com.practice.rest.webservices.restfulwebservices.user;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.practice.rest.webservices.restfulwebservices.post.Post;

@Service
public class UserDaoService {

	@Autowired
	private UserDaoRepository userRepository;
	
	
	
	//retrieve all users
	public List<User> retriveAllUsers() {
		// TODO Auto-generated method stub
		
		return userRepository.findAll();
	}
	
	//retrieve user by userid
		public User retriveUserById(int id) {
			// TODO Auto-generated method stub
			Optional<User> optional = userRepository.findById(id);
			if(optional.isEmpty())
				throw new UserNotFoundException("id:"+id);
			
			return optional.get();
		}

		public User createUser(User user) {
			// TODO Auto-generated method stub
			User savedUser = userRepository.save(user);
			return savedUser;
		}

		public void deletUserByID(int id) {
			// TODO Auto-generated method stub
			retriveUserById(id);
			
			userRepository.deleteById(id);
			
		}

		public List<Post> retrivePostsForUser(int id) {
			// TODO Auto-generated method stub
			Optional<User> optional = userRepository.findById(id);
			if(optional.isEmpty()){
				throw new UserNotFoundException("id:"+id);
			}
			User user = optional.get();
			return user.getPosts();
		}
	
	
	//save user
	//retrieve specific user
	
}	


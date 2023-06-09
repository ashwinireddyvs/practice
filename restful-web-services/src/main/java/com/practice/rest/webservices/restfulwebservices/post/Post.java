package com.practice.rest.webservices.restfulwebservices.post;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.practice.rest.webservices.restfulwebservices.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Post {
	@Id
	@GeneratedValue
	private int id;
	
	@NonNull
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)// by default it is Eager ==> when we fetch post details it  fetch userdetails together, for lazy it wont fetch with posts 
	@JsonIgnore
	private User user;
}

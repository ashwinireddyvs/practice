package com.practice.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.practice.rest.webservices.restfulwebservices.post.Post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity(name = "USER_DETAILS")

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
//@JsonIgnoreProperties("field1","field2") --> static filter
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NonNull
	@Size(min=2,message = "Name should have atleast 2 characters")
	@JsonProperty("username")
	private String name;
	
	//@JsonIgnore static filtering 
	@NonNull
	@Past(message = "Birthdate should be in past")
	private LocalDate birthDate;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;
}

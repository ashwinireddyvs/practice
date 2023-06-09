package com.practice.springboot.MyFirstWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoServiceJpa {
	
	@Autowired
	private TodoRepository repository;
	
	
	public List<Todo> findByUserName(String username){
//		
//		Predicate<? super Todo> predicate = t -> t.getUsername().equalsIgnoreCase(username);
//		return todos.stream().filter(predicate).toList();
		return repository.findByUsername(username);
	
	}
	
	public void addTodo(Todo todo) {
		//todos.add(new Todo(++todoCount,userName,description,targetDate,done));
		repository.save(todo);
	}
	
	public void deleteById(int id) {
		//Predicate<? super Todo> predicate = t -> t.getId() == id;
		repository.deleteById(id);
	}
	
	public Todo findById(int id) {
		
		return repository.findById(id).get();
	}

	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		
		repository.save(todo);
	}

	
	
	
}

package com.practice.springboot.MyFirstWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

//@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 0;
	static {
		todos.add(new Todo(++todoCount,"ashwini","Learn AWS",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todoCount,"in28Minutes","Learn Devops",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todoCount,"in28Minutes","Learn fullstack development",LocalDate.now().plusYears(3),false));
	}
	
	public List<Todo> findByUserName(String username){
		
		Predicate<? super Todo> predicate = t -> t.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String userName,String description,LocalDate targetDate,boolean done) {
		todos.add(new Todo(++todoCount,userName,description,targetDate,done));
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = t -> t.getId() == id;
		todos.removeIf(predicate );
	}
	
	public Todo findById(int id) {
		Predicate<? super Todo> predicate = t -> t.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteById(todo.getId());
		todos.add(todo);
	}

	
	
	
}

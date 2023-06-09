package com.practice.springboot.MyFirstWebApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@SessionAttributes("name")
@Slf4j
public class TodoControllerjPA {

	@Autowired
	private TodoServiceJpa service;
	




	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String userName = getLoggedinUserName();
		log.info("userName=======>{}",userName);
		List<Todo> todos = service.findByUserName(userName);
		model.put("todos", todos);
		return "listTodos";
	}

	
	
	@RequestMapping(value="add-todo",method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String userName = getLoggedinUserName();
		//this is one time binding
		Todo todo = new Todo(0,userName,"",LocalDate.now().plusYears(1),false);
		model.put("todo",todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.POST)
	public String addNewTodoPage(ModelMap model,@Valid  Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String userName = getLoggedinUserName();
		todo.setUsername(userName);
		service.addTodo(todo);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="delete-todo",method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		//Delete todo
		service.deleteById(id);
		
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo",method = RequestMethod.GET)
	public String showUpdateodoPage(@RequestParam int id,ModelMap model) {
		
		Todo todo = service.findById(id);
		model.put("todo",todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo",method = RequestMethod.POST)
	public String updateTodoPage(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String userName = getLoggedinUserName();
		todo.setUsername(userName);
		service.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	private String getLoggedinUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}

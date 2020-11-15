package com.darkonnen.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darkonnen.test.model.Todo;
import com.darkonnen.test.service.TodoService;

@RestController
@CrossOrigin(origins="localhost:4200")
@RequestMapping("/todos")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/all")
	public List<Todo> getAll(){
		return todoService.getAll();
	}
	
	

}

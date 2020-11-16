package com.darkonnen.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darkonnen.test.model.Todo;
import com.darkonnen.test.service.TodoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping("/{username}/todos")
	public ResponseEntity<List<Todo>> getAll(@PathVariable("username") String username) {
		List<Todo> todos = todoService.getAll();
		return new ResponseEntity<List<Todo>>(todos, HttpStatus.OK);
	}

	@PostMapping("/{username}/todos")
	public ResponseEntity<Todo> create(@PathVariable("username") String username, @Valid @RequestBody Todo todo) {
		Todo t = todoService.create(todo);
		return new ResponseEntity<Todo>(t, HttpStatus.OK);
	}

}

package com.darkonnen.test.service;

import java.util.List;

import com.darkonnen.test.model.Todo;

public interface TodoService {
	
	List<Todo> getAll();
	
	Todo getById(Integer id);
		
	Todo create(Todo todo);
	
	Todo update(Todo todo);
	
	boolean delete(Integer id);


}

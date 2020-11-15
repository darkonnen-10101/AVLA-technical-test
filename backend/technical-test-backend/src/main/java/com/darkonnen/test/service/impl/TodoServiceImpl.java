package com.darkonnen.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darkonnen.test.model.Todo;
import com.darkonnen.test.repository.TodoRepository;
import com.darkonnen.test.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public List<Todo> getAll() {
		return todoRepository.findAll();
	}

	@Override
	public Todo getById(Integer id) {
		Optional<Todo> optional = todoRepository.findById(id);
		
		if (optional.isPresent()) {
			return optional.get();
		}
		
		return new Todo();

	}

	@Override
	public Todo create(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public Todo update(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public boolean delete(Integer id) {
		todoRepository.deleteById(id);
		return true;
	}

}

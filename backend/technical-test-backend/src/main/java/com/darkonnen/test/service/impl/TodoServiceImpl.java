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
		String default_user = todoRepository.query_asigned_user();
		if(default_user == null) {
			// Because if DB is empty, it does not assign any value.
			// User must be registered in order to be assigned.
			// This is because the static list of users is not a POJO or Entity by itself.
			// So it cant assign the task to user1, for example, if user1 doesn't exist yet
			// It will add it ONLY if the user has already been chosen for a task.
			todo.setAsignedUser("user1");
			// The simplest solution to this is to create a number of tasks equals to the number of current users.
		}
		else if (todo.getAsignedUser().equals("")) {
			todo.setAsignedUser(default_user);
		}

		return todoRepository.save(todo);
	}

	@Override
	public boolean delete(Integer id) {
		todoRepository.deleteById(id);
		return true;
	}

}

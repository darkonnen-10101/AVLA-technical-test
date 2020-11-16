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
		if (todo.getAsignedUser().equals("")) {
			String default_user = todoRepository.query_asigned_user();
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

/*
 
 
//			ArrayList<String> users = new ArrayList<String>();

//			List<Todo> todos = todoRepository.findAll();
//			for (Todo t : todos) {
//				users.add(t.getAsignedUser());
//			}
//			System.out.println("********");

//			List<Object[]> list = todoRepository.ocurrencies_list();
//			System.out.println(todoRepository.query_asigned_user());
//			System.out.println("One result");
//			System.out.println(list);

//			for (Object[] obj : list) {
//				System.out.println(obj[0].getClass());
//				System.out.println(obj[1].getClass());
//				String key = (String) obj[0];
//				BigInteger value = (BigInteger) obj[1];
//                System.out.println(key);
//                System.out.println(value);
//			}

//			System.out.println("********");
//			System.out.println(list);
//			Ocurrencies.countFrequencies(users);

 
 */

package com.darkonnen.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darkonnen.test.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{

}

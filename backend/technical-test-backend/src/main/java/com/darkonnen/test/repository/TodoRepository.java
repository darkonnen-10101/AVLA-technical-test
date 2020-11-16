package com.darkonnen.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.darkonnen.test.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{
	

    @Query(value="SELECT todo.asigned_user FROM Todo WHERE todo.asigned_user !='' ORDER BY todo.asigned_user ASC LIMIT 1", nativeQuery=true)
    String query_asigned_user();

}

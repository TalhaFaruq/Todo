package com.fullstack.todolist.Repository;

import com.fullstack.todolist.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {
}

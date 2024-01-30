package com.example.todolist.repository;


import com.example.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

//repository são interfaces que extenden uma interdface que é provida pelo proprio springboot
public interface TodoRepository extends JpaRepository<Todo, Long> {
}

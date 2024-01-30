package com.example.todolist.controller;

import com.example.todolist.entity.Todo;
import com.example.todolist.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    //esta é a camada web, é aqui que nós interagimos com o nosso serviço
    //adicionamos todas as operações que adicionamos no service
    private TodoService todoService;
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @PostMapping
    List<Todo> create(@RequestBody @Valid Todo todo){
        return todoService.create(todo);
    }

    @DeleteMapping("{id}") //O {} significa que este valr foi recuperado da requisição
    List<Todo> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }

    @PutMapping
    List<Todo> update(@RequestBody Todo todo){
        return todoService.update(todo);
    }

    @GetMapping
    List<Todo> list(){
        return todoService.list();
    }


}

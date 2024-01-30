package com.example.todolist.service;

import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    //aqui estamos fazendo injeção via construtor, por este motivo não utilizei o @autorired
    private TodoRepository todoRepository;
    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }
    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list(); //estamos retornando o list() para evitar repetições
    }

    public List<Todo> delete(Long id){ //passamos apenas o id de quem queremos remover
        todoRepository.deleteById(id);
        return list();  //estamos retornando o list() para evitar repetições
    }

    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();  //estamos retornando o list() para evitar repetições
    }
    public List<Todo> list() {
        // formas de ordenar
        Sort sort = Sort.by(Sort.Order.desc("prioridade"))
                .and(Sort.by(Sort.Order.asc("nome")));
        return todoRepository.findAll(sort); // queremos retornar tudo
    }
}

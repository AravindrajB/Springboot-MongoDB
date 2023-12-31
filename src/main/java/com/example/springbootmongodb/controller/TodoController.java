package com.example.springbootmongodb.controller;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.springbootmongodb.model.TodoDTO;
import com.example.springbootmongodb.repository.TodoRespository;

@RestController
public class TodoController {

	@Autowired
	private TodoRespository todoRepo;
	
	@GetMapping("/todos")
	public ResponseEntity<?> getAllTodos(){
		
		List<TodoDTO> todos = todoRepo.findAll();
		if(todos.size() > 0) {
			
			return new ResponseEntity<List<TodoDTO>>(todos ,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("No todos available",HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/todo/post")
	public ResponseEntity<?> createTodo(@RequestBody TodoDTO todo){
		
		try {
			todo.setCreatedAt(new Date(System.currentTimeMillis()));
			todoRepo.save(todo);
			return new ResponseEntity<TodoDTO>(todo , HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}

package com.example.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootmongodb.model.TodoDTO;

@Repository
public interface TodoRespository extends MongoRepository<TodoDTO, String>{


}

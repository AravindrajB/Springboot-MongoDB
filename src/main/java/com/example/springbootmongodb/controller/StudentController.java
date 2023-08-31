package com.example.springbootmongodb.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmongodb.Dto.StudentDto;
import com.example.springbootmongodb.Service.StudentService;
import com.example.springbootmongodb.model.Student;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/addStudent")
	public StudentDto addrecord(@RequestBody StudentDto data) {
		return service.addRecord(data);
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> getrecord() {
		return service.getRecord();
	}
	
	@GetMapping("/getSingleStudent/{id}")
	public Optional<Student> getsinglerecord(@PathVariable String id) {
		return service.getSingleRecord(id);
	}

	@DeleteMapping("/deleteStudent/{id}")
	public String delete(@PathVariable String id) {
		return service.deleteRecord(id);
	}
	
	@PutMapping("/updaterecord/{id}")
	public StudentDto update(@RequestBody StudentDto data ,@PathVariable String id) {
		return service.updateRecord(data , id);
	}
}

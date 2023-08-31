package com.example.springbootmongodb.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.springbootmongodb.model.Employee;
import com.example.springbootmongodb.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository emp;

	@PostMapping("/addemployee")
	public Employee addemployee(@RequestBody Employee emp_add) {

		return emp.save(emp_add);
	}

	@PostMapping("/add/data")
	public String add(@RequestBody Employee emp_add) {

//		return "Record added"+ emp_add ;
		if (emp.save(emp_add) != null) {

			return "Record added" + emp_add;

		} else {
			return "Not found" + emp_add;
		}
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return emp.findAll();
	}

	@GetMapping("/getOne/{id}")
	public Optional<Employee> getOneRecord(@PathVariable("id") int id) {
		Optional<Employee> findById = emp.findById(id);
		return findById;
	}

	@GetMapping("/getOneRecord/{id}")
	public ResponseEntity<?> getOne(@PathVariable("id") int id) {

		Optional<Employee> findById = emp.findById(id);
		if (findById.isPresent()) {
			return new ResponseEntity<>(findById.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		emp.deleteById(id);
		return "Record deleted:" + id;
	}

	}

	

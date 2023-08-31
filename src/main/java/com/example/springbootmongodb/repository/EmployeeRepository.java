package com.example.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springbootmongodb.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

//	Employee setUpdate(Employee update_data, int id);

//	Employee Update(Employee update_data, int id);


}

package com.example.springbootmongodb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootmongodb.Dto.StudentDto;
import com.example.springbootmongodb.model.Student;
import com.example.springbootmongodb.repository.StudentRepository;

@Service
public class StudentService {
	
	StudentDto dto = new StudentDto();
	Student result = new Student();
	
	@Autowired
	private StudentRepository repository;

	public StudentDto addRecord(StudentDto data) {

		result.setId(data.getId());
		result.setName(data.getName());
		repository.save(result);
	    // below two lines no need
		dto.setId(data.getId());
		dto.setName(data.getName());
		dto.setMsg("Record Added");
		return dto;
	}

	public List<Student> getRecord() {
		List<Student> findAll = repository.findAll();
		return findAll;
	}

	public Optional<Student> getSingleRecord(String id) {
		Optional<Student> result = repository.findById(id);
		return result;
	}

	public String deleteRecord(String id) {
		Optional<Student> findById = repository.findById(id);
		if (findById != null) {
			repository.deleteById(id);
			return "Record will be delete";
		}else {
			return "Record Does Not exits in database";
		}
		
	}

	public StudentDto updateRecord(StudentDto data, String id) {
		Optional<Student> out = repository.findById(id);
		
		if (out == null) {
			
			dto.setMsg("Record does not exits in db");
			return dto;
			
		} else {
			
			result.setName(data.getName());
			repository.save(result);
			dto.setId(id);
			dto.setName(data.getName());
			dto.setMsg("Record Updated");
			return dto;
		}
	}

}

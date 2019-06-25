package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repositories.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping
	public ResponseEntity<Iterable<Employee>> findAll() {

		Iterable<Employee> employees = employeeRepository.findAll();

		return new ResponseEntity<Iterable<Employee>>(employees, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Employee> createNew(@RequestBody Employee rqBody) {

		Employee employee = employeeRepository.save(new Employee(rqBody.getName(), rqBody.getAddress()));

		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Employee> delete(@PathVariable Long id) {

		employeeRepository.deleteById(id);

		return new ResponseEntity<Employee>(HttpStatus.OK);
	}

}

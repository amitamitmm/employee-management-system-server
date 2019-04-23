package com.aptota.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aptota.beans.Employee;
import com.aptota.exceptions.EmployeeNotFoundException;
import com.aptota.service.EmployeeService;

@RestController
@RequestMapping(path="/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(path="/demo")
	public Employee greeting() {
		return Employee.getSampleEmployee();
	}
	
	@GetMapping(path="")
	public List<Employee> findAllEmployee() {
		log.info("Retriving all employee");
		return employeeService.findAllEmployee();
	}
	
	@GetMapping(path="/{id}")
	public Employee getEmployee(@PathVariable("id") long id) {
		log.info("Getting Employee with id :: "+id);
		return employeeService.findEmployee(id);
	}
	
	@PostMapping(path="")
	public Employee addEmployee(@RequestBody Employee employee) {
		log.info("Adding employee...");
		Employee emp =  employeeService.addEmployee(employee);
		log.info("Employee has been added successfully!! :: "+emp);
		return emp;
	}
	
	@PutMapping(path="/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
		log.info("Updating employee :: "+employee);
		return employeeService.updateEmployee(employee, id);
	}
	
	@DeleteMapping(path="/{id}")
	public Employee deleteEmployee(@PathVariable long id) {
		log.info("Deleting Employee with id :: "+id);
		return employeeService.deleteEmployee(id);
	}
	
	@ExceptionHandler(value= EmployeeNotFoundException.class)
	public ResponseEntity<Object> exception(EmployeeNotFoundException ex){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", true);
		map.put("message", ex.getMessage());
		map.put("exception", "Handle by controller exception hanler");
		
		return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
	}
	
}














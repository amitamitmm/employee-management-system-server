package com.aptota.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aptota.beans.Employee;
import com.aptota.exceptions.EmployeeNotFoundException;
import com.aptota.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> findAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public Employee findEmployee(long id) {
		Optional<Employee> optEmp =  employeeRepository.findById(id);
		if(optEmp.isPresent()) {
			return optEmp.get();
		}
		throw new EmployeeNotFoundException("Employee not found with id "+id);
	}
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	
	public Employee updateEmployee(Employee emp, long id) {
		Optional<Employee> oldEmployee = employeeRepository.findById(id);
		if(oldEmployee.isPresent()) {
			Employee employee = oldEmployee.get();
			employee.setFirstName(emp.getFirstName());
			employee.setLastName(emp.getLastName());
			employee.setEmail(emp.getEmail());
			employee.setGender(emp.getGender());
			employee.setJob(emp.getJob());
			employee.setMobileNumber(emp.getMobileNumber());
			employee.setSalary(emp.getSalary());
			employee.setDoj(emp.getDoj());
			employee.setDob(emp.getDob());
			return employeeRepository.save(employee);
		}
		throw new EmployeeNotFoundException("Employee Update Failed!! Employee not found with id "+id);
	}
	
	public Employee deleteEmployee(long id) {
		Optional<Employee> employeeObj = employeeRepository.findById(id);
		if(employeeObj.isPresent()) {
			Employee emp = employeeObj.get();
			employeeRepository.delete(emp);
			return emp;
		}
		throw new EmployeeNotFoundException("Employee Deletion Failed!! Employee does not exist with id "+id);
	}
	
	
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeDataAlreadyExistsException;
//import com.example.demo.service.EmployeeDataException;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) throws EmployeeDataAlreadyExistsException {
		return service.saveEmployee(employee);
	}
	@PostMapping("/employees")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees){
		return service.saveEmployees(employees);
	}
	@GetMapping("/employee")
	public List<Employee> findAllemployees(){
		return service.getEmployees();
	}
	@GetMapping("/employee1/{id}")
	public Employee findEmployeeById(@PathVariable Integer id) {
		return service.getEmployeeById(id);
	}
	@GetMapping("/employee2/{name}")
	public Employee findEmployeeByName(@PathVariable String name) {
		return service.getEmployeeByName(name);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee e) {
		return service.updateEmployee(e);
	}
	@PutMapping("/update/{salary}")
	public String updateEmployeeBySalary(@PathVariable String salary , @RequestBody Employee employee) {
		return service.updateEmployeeBySalary(salary, employee);
	}
	
	

}

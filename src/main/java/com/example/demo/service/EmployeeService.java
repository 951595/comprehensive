package com.example.demo.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeDataAlreadyExistsException;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee) {
		Employee ee=employeeRepository.findById(employee.getId()).orElse(null);
		if(ee == null) {
		 return employeeRepository.save(employee);
		 
		}else
			  throw new EmployeeDataAlreadyExistsException("Employee is already exists..");
	}
	
	public List<Employee> saveEmployees(List<Employee>employees) {
		return employeeRepository.saveAll(employees);
	}
	public List<Employee>getEmployees(){
		//Sort sortorder = Sort.by("salary");
		return employeeRepository.findAll(Sort.by("salary").descending().and(Sort.by("name")));
	}
	
	public Employee getEmployeeById(Integer id) {
		return employeeRepository.findById(id).orElse(null);
		
	     
	}
	public Employee getEmployeeByName(String name) {
		return employeeRepository.findByName(name);
	}
	
	public String deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		return "employee is deleted"+id;
	}
	public Employee updateEmployee(Employee em) {
		Employee ep=employeeRepository.findById(em.getId()).orElse(null);
		ep.setName(em.getName());
		ep.setSalary(em.getSalary());
		ep.setDesignation(em.getDesignation());
		return employeeRepository.save(ep);
		
	}

	public String updateEmployeeBySalary(String salary , Employee employee) {
		// TODO Auto-generated method stub
	     employeeRepository.save(employee);
		return "update succeessfully"+salary;
		
	}
	
    

}

package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Employee;
import com.app.service.IEmployeeService;
@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
	@Autowired
	private IEmployeeService empService;

	public EmployeeController() {
		System.out.println("in constroctor"+getClass());
	}
	@GetMapping
	public List<Employee>listAllEmp(){
		System.out.println("List of Employees");
		return empService.getAllEmpDetails();
	}
	
	@PostMapping
	public Employee saveEmpDetails(@RequestBody Employee emp) {
		System.out.println("in insert Details"+emp);
		return empService.saveEmpDetails(emp);	
	}
	@DeleteMapping("/{empId}")
	public String deleteEmpDetails(@PathVariable int empId) {
		System.out.println("in delete emp"+empId);
		return empService.deleteEmpDetails(empId);
	}
	
	@GetMapping("/{id}")
	public Employee getEmpDetails(@PathVariable int id) {
		System.out.println("int get emp"+id);
		return empService.getEmpDetails(id);
	}
	@PutMapping
	public Employee updateEmpDetails(@RequestBody Employee emp) {
		System.out.println("in update emp"+emp);
		return empService.updateEmpDetails(emp);
	}
	
	
	
	
	
}

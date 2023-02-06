package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface IEmployeeService {
	//get all emp
	List<Employee>getAllEmpDetails();
	//insert
	public Employee saveEmpDetails(Employee transientemp);
	
	public String deleteEmpDetails(int empId);
	
	Employee getEmpDetails(int empId);
	
	Employee updateEmpDetails(Employee updateDetachedEmp);
}

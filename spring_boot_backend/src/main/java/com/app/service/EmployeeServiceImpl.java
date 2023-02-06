package com.app.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.EmployeeRepository;
import com.app.pojos.Employee;
@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeRepository empRepo;
	@Override
	public List<Employee>getAllEmpDetails(){
		return empRepo.findAll();
		
	}
	@Override
	public Employee saveEmpDetails(Employee transientemp) {
		
		return 	empRepo.save(transientemp);
		
	}
	@Override
	public String deleteEmpDetails(int empId) {
		String msg="Deletion of emp Details Failed!!!!";
		if(empRepo.existsById(empId)) {
			empRepo.deleteById(empId);
		msg="Emp Details delated successfull,for emp id"+empId;	
		}
		return msg;
	}
	@Override
	public Employee getEmpDetails(int empId){
		// TODO Auto-generated method stub
		return empRepo.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid emp id !!!!!!" + empId));
	}
	@Override
	public Employee updateEmpDetails(Employee updateDetachedEmp) {
		
		return empRepo.save(updateDetachedEmp);
	}
	
	
	
	
}

package com.trannammy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trannammy.model.Employee;
import com.trannammy.repository.EmployeeReporitory;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeReporitory employeeReporitory;
	
	public List<Employee> getAll(){
		return employeeReporitory.getAll();
	}
	
	public int insertEmployee(Employee employee) {
		return employeeReporitory.insertEmployee(employee);
	}
	
	public int updateEmployee(Employee employee) {
		return employeeReporitory.updateEmployee(employee);
	}
	
	public int deleteEmloyee(int id) {
		return employeeReporitory.deleteEmloyee(id);
	}
}

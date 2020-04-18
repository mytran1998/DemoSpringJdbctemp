package com.trannammy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trannammy.model.Employee;
import com.trannammy.service.EmployeeService;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		// Su dung JdbcTemplate
		EmployeeService service = context.getBean("employeeService", EmployeeService.class);
		
		// Them moi
		//service.insertEmployee(new Employee("Nhu Quynh", "quynh@gmail.com", "Hue", "77777777"));
		
		// Cap nhat
		//Employee emp = new Employee(1, "AAAA", "emilama@gmail.com", "QB", "99999999");
		//service.updateEmployee(emp);
		
		// Xoa
		service.deleteEmloyee(2);
		System.out.println(service.getAll());
	}

}

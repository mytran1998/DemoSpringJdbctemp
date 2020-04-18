package com.trannammy.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.trannammy.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Employee(rs.getInt("id"), 
							rs.getString("name"), 
							rs.getString("email"), 
							rs.getString("address"), 
							rs.getString("phone"));
	}
	
}

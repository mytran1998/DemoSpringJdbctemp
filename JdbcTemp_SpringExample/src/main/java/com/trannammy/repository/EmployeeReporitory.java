package com.trannammy.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trannammy.mapper.EmployeeMapper;
import com.trannammy.model.Employee;

@Repository
public class EmployeeReporitory {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Employee> getAll() {
		String query = "SELECT * FROM dbo.Employee";
		return jdbcTemplate.query(query, new EmployeeMapper());
	}
	
	public int insertEmployee(Employee employee) {
		String query = "INSERT INTO dbo.Employee( name, email, address, phone ) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(query, employee.getName(), employee.getEmail(), 
										employee.getAddress(), employee.getPhone());
	}
	
	public int updateEmployee(Employee employee) {
		String query = "UPDATE dbo.Employee SET name = ?, email = ?, address = ?, phone = ? WHERE id = ?";
		return jdbcTemplate.update(query, employee.getName(), employee.getEmail(), 
										employee.getAddress(), employee.getPhone(), employee.getId());
	}
	
	public int deleteEmloyee(int id) {
		String query = "DELETE FROM dbo.Employee WHERE id = ?";
		return jdbcTemplate.update(query, id);
	}
	
}

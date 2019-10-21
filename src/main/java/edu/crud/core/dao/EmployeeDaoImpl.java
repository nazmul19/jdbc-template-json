package edu.crud.core.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.crud.core.DbUtil;
import edu.crud.core.model.Employee;
import edu.crud.core.model.EmployeeRowMapper;

@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> getAllEmployees() {
		String query = "SELECT * from employees";
		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		List<Employee> list = jdbcTemplate.query(query, rowMapper);

		return list;
	}

	@Override
	public Employee findeEmployeeById(int id) {
		String query = "SELECT * FROM employees WHERE employee_id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(query, rowMapper, id);

		return employee;
	}

	@Override
	public long addEmployee(Employee employee) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String query = "INSERT INTO employees(first_name, last_name, email, phone, job_title, other_attributes) VALUES(?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(connection -> {
	        PreparedStatement ps = connection
	          .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	          ps.setString(1, employee.getFirstName());
	          ps.setString(2, employee.getLastName());
	          ps.setString(3, employee.getEmail());
	          ps.setString(4, employee.getPhone());
	          ps.setString(5, employee.getJobTitle());
	          ps.setString(6,  DbUtil.serializeJsonMap(employee.getOtherAttributes()));
	          return ps;
	        }, keyHolder);
		
//		jdbcTemplate.update(query, employee.getFirstName(), employee.getLastName(),
//				employee.getEmail(), employee.getPhone(), employee.getJobTitle(), keyHolder);
		return (long) keyHolder.getKey().longValue();
	}

	@Override
	public void updateEmployee(Employee employee) {
		String query = "UPDATE employees SET first_name=?, last_name=?, email=?, phone=?, job_title=? WHERE employee_id=?";
		jdbcTemplate.update(query, employee.getFirstName(), employee.getLastName(), employee.getEmail(),
				employee.getPhone(), employee.getJobTitle(), employee.getEmployeeId());

	}

	@Override
	public void deleteEmployee(int id) {
		String query = "DELETE FROM employees WHERE employee_id=?";
		jdbcTemplate.update(query, id);
	}
}

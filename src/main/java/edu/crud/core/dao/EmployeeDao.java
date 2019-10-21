package edu.crud.core.dao;

import java.util.List;

import edu.crud.core.model.Employee;

public interface EmployeeDao {
	public List<Employee> getAllEmployees();

	public Employee findeEmployeeById(int id);

	public long addEmployee(Employee employee);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(int id);
}

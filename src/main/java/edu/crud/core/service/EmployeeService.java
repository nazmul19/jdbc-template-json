package edu.crud.core.service;

import java.util.List;

import edu.crud.core.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();

	public Employee findEmployeeById(int id);

	public long addEmployee(Employee employee);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(int id);
}

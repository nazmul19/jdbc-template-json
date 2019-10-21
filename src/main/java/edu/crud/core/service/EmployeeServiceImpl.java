package edu.crud.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.crud.core.dao.EmployeeDaoImpl;
import edu.crud.core.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDaoImpl employeeDao;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee findEmployeeById(int id) {
		return employeeDao.findeEmployeeById(id);
	}

	@Override
	public long addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
	}
}

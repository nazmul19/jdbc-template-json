package edu.crud.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.crud.core.model.Employee;
import edu.crud.core.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Employee editEmployee(@PathVariable int id) {
		return employeeService.findEmployeeById(id);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public long insertEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
	}
}
package edu.crud.core.model;

import java.util.Map;

import lombok.Data;

@Data
public class Employee {
	private Long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String jobTitle;
	private Map<String, Object> otherAttributes;
}

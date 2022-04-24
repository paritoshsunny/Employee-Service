package com.sunny.microservice.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.microservice.employee.VO.ResponseTemplateVO;
import com.sunny.microservice.employee.entity.Employee;
import com.sunny.microservice.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getEmployeeWithDepartment(@PathVariable("id") Long id) {
		return employeeService.getEmployeeWithDepartment(id);
	}

}

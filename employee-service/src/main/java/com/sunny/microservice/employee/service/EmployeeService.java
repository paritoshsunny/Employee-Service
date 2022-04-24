package com.sunny.microservice.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sunny.microservice.employee.VO.Department;
import com.sunny.microservice.employee.VO.ResponseTemplateVO;
import com.sunny.microservice.employee.entity.Employee;
import com.sunny.microservice.employee.repository.EmployeeRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
//	@Autowired
//	DepartmentClient client;

	@Autowired
	private RestTemplate restTemplate;

	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@CircuitBreaker(name = "demoServiceCircuitBreaker", fallbackMethod = "getDepartmentByIdFallback")
	public ResponseTemplateVO getEmployeeWithDepartment(Long id) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		Employee emp = employeeRepo.findById(id).orElse(null);
		vo.setEmployee(emp);
		
//		Optional<Department> department1= client.getDepartmentById(emp.getDeptId());
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + emp.getDeptId(),
				Department.class);
		vo.setDepartment(department);
		return vo;
	}

	
	public ResponseTemplateVO getDepartmentByIdFallback(Exception e) {
		Employee emp=new Employee();
		Department department=new Department();
		ResponseTemplateVO templateVO=new ResponseTemplateVO();
		
		emp.setFirstName("NOT FOUND");
		emp.setLastName("NOT FOUND");
		emp.setEmpId(0L);
		emp.setEmail("NOT FOUND");
		emp.setDeptId(0L);
		
		department.setDeptAddress("NOT FOUND");
		department.setDeptCode("NOT FOUND");
		department.setDeptId(0L);
		department.setDeptName("NOT FOUND");
		
		templateVO.setDepartment(department);
		templateVO.setEmployee(emp);
		
		return templateVO;
	}
}

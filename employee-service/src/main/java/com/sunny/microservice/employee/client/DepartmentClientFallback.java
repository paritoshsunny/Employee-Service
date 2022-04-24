package com.sunny.microservice.employee.client;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sunny.microservice.employee.VO.Department;

@Component
public class DepartmentClientFallback implements DepartmentClient{

	@Override
	public Optional<Department> getDepartmentById(Long id) {
		Department department=new Department();
		department.setDeptAddress("Not Found");
		department.setDeptCode("Not Found");
		department.setDeptId(null);
		department.setDeptName("Not Found");
		return Optional.ofNullable(department);
	}

}

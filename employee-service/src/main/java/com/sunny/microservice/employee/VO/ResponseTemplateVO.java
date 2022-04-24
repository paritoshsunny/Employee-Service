package com.sunny.microservice.employee.VO;

import java.util.Optional;

import com.sunny.microservice.employee.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVO {
	
	private Employee employee;
	private Department department;

}

package com.sunny.microservice.employee.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	
	private Long deptId;
	private String deptName;
	private String deptAddress;
	private String deptCode;

}

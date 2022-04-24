package com.sunny.microservice.employee.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sunny.microservice.employee.VO.Department;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name= "DEPARTMENT-SERVICE")
@Component
public interface DepartmentClient {
	
	@GetMapping("/departments/{id}")
	@CircuitBreaker(name = "demoServiceCircuitBreaker", fallbackMethod = "getDepartmentByIdFallback")
	public Optional<Department> getDepartmentById(@PathVariable("id") Long id);
	
	

}

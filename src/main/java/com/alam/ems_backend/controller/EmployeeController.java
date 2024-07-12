package com.alam.ems_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alam.ems_backend.entity.Employee;
import com.alam.ems_backend.service.EmployeeService;

@CrossOrigin("*")
@RequestMapping("/api/employee")
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.OK);
	}
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee){
		return employeeService.saveEmployee(employee);
	}
	
	@PutMapping("/updateEmployee/{employeeId}")
	public Employee updateEmployee(@PathVariable("employeeId") Long employeeId ,@RequestBody Employee employee){
		return employeeService.updateEmployee(employeeId,employee);
	}
	
	@GetMapping("/getEmployeeById/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId") Long employeeId){
		return employeeService.getByEmployeeId(employeeId);
	}
	
	@DeleteMapping("/deleteEmployeeById/{employeeId}")
	public String deleteEmployeeById(@PathVariable("employeeId") Long employeeId){
		return employeeService.deleteEmployeeById(employeeId);
	}

}

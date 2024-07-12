package com.alam.ems_backend.service;

import java.util.List;

import com.alam.ems_backend.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployee();

	public Employee saveEmployee(Employee employee);

	public Employee updateEmployee(Long employeeId, Employee employee);

	public Employee getByEmployeeId(Long id);

	public String deleteEmployeeById(Long employeeId);

}

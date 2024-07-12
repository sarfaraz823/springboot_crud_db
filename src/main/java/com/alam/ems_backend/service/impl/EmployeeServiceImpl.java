package com.alam.ems_backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alam.ems_backend.entity.Employee;
import com.alam.ems_backend.repository.EmployeeRepository;
import com.alam.ems_backend.service.EmployeeService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Long employeeId, Employee employee) {

		Employee empObjDb = employeeRepository.findById(employeeId).get();

		BeanUtils.copyProperties(employee, empObjDb);
		empObjDb.setId(employeeId);
		return employeeRepository.save(empObjDb);
	}

	@Override
	public Employee getByEmployeeId(Long id) {

		return employeeRepository.findById(id).get();
	}

	@Override
	public String deleteEmployeeById(Long employeeId) {

		employeeRepository.deleteById(employeeId);
		return "Employee deleted successfully..";
	}

}

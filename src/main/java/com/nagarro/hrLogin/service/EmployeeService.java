package com.nagarro.hrLogin.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.hrLogin.constants.Constants;
import com.nagarro.hrLogin.entity.Employee;
import com.nagarro.hrLogin.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public List<Employee> allEmployees = new ArrayList<Employee>();
	RestTemplate restTemplate = new RestTemplate();

	public Employee[] getEmployees() {

		
		Employee[] employeeList = restTemplate.getForObject(Constants.URI, Employee[].class);
//		for (Employee emp : employeeList) {
//			Employee employee = new Employee();
////			employee.setId(emp.getId());
//			employee.setName(emp.getName());
//			employee.setEmail(emp.getEmail());
//			employee.setLocation(emp.getLocation());
//			employee.setDateOfBirth(emp.getDateOfBirth());
//			employeeRepo.save(employee);
//			allEmployees.add(employee);
//		}
		return employeeList;
	}

	public Employee getMatchingEmployee(long id) {
		RestTemplate restTemplate = new RestTemplate();
		Employee employee = restTemplate.getForObject(Constants.URI + id, Employee.class);
		return employee;
	}
	
	public HttpEntity<Employee> getEntity(Employee employee){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		Employee newEmployee = new Employee();
		newEmployee.setName(employee.getName());
		newEmployee.setLocation(employee.getLocation());
		newEmployee.setEmail(employee.getEmail());
		newEmployee.setDateOfBirth(employee.getDateOfBirth());
		HttpEntity<Employee> entity = new HttpEntity<>(newEmployee,headers);
		return entity;
	}
	
	public Employee addNewEmployee(Employee employee) {
		HttpEntity<Employee> entity = getEntity(employee);
		
		return restTemplate.postForObject(Constants.URI, entity, Employee.class);
	}
	
	public void updateEmployee(Employee employee) {
		HttpEntity<Employee> entity = getEntity(employee);
		restTemplate.put(Constants.URI+employee.getId(), entity, employee.getId());
	}

}

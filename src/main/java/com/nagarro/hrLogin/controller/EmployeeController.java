package com.nagarro.hrLogin.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.hrLogin.constants.Constants;
import com.nagarro.hrLogin.entity.Employee;
import com.nagarro.hrLogin.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(dateFormat, false));
	}

	@GetMapping("/employeeList")
	public String viewHomePage(Model model) {
		Employee[] employeeList = employeeService.getEmployees();
		model.addAttribute(employeeList);
		return Constants.EMPLOYEELIST;
	}

	@GetMapping("/editEmployee")
	public String viewEditPage(@RequestParam("employeeId") Long employeeId, Model model) {

		Employee employee = employeeService.getMatchingEmployee(employeeId);
		model.addAttribute(employee);
		return Constants.EDITEMPLOYEE;
	}

	@GetMapping("/addEmployee")
	public String viewAddPage() {
		return Constants.ADDEMPLOYEE;
	}

	@PostMapping("/addEmployee")
	public String addEmployee(Employee employee) {
		employeeService.addNewEmployee(employee);
		return Constants.REDIRECTURL;
	}

	@PostMapping("/editEmployee")
	public String editEmployee(Employee employee) {
		employeeService.updateEmployee(employee);
		return Constants.REDIRECTURL;
	}

}

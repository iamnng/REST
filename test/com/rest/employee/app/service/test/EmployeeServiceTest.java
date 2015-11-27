package com.rest.employee.app.service.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rest.employee.app.service.EmployeeService;


public class EmployeeServiceTest {
	private EmployeeService employeeService;
	
	@Before
	public void init(){
		employeeService = new EmployeeService();
	}
	
	@Test
	public void testGetAllEmployees(){
		System.out.println("Testing getAllEmployees()...");
		System.out.println(employeeService.getAllEmployees());
	}
	
	@Test
	public void testGetEmployeeById(){
		System.out.println("Testing getEmployeeById()...");
		System.out.println(employeeService.getEmployeeById("003"));
	}
	
	@Test
	public void testGetEmployeeByName(){
		System.out.println("Testing getEmployeeByName()...");
		System.out.println(employeeService.getEmployeeByFirstName("Sachin"));
	}
	
	@Test
	public void testUpdateEmployee(){
		System.out.println("Testing updateEmployee()...");
		System.out.println(employeeService.updateEmployeeName("004", "Virat", "Kohli"));
		System.out.println(employeeService.getAllEmployees());
	}
	
	@Test
	public void testAddEmployee(){
		System.out.println("Testing createEmployee()...");
		System.out.println(employeeService.createEmployee("006", "Anil", "Kumble", "43", "Banglore"));
		System.out.println(employeeService.getAllEmployees());
	}
	
	@Test
	public void testDeleteEmployee(){
		System.out.println("Testing deleteEmployee()...");
		System.out.println(employeeService.deleteEmployee("002"));
		System.out.println(employeeService.getAllEmployees());
	}
	
	@After
	public void cleanup(){
		employeeService = null;
	}
}

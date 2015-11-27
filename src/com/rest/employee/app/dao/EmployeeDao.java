package com.rest.employee.app.dao;

import java.util.ArrayList;
import java.util.List;

import com.rest.employees.app.to.Employee;

public class EmployeeDao{
	private List<Employee> employeeList = new ArrayList<Employee>();

	{
		employeeList.add(new Employee(001, 	"Sachin", 	"Tendulkar", 	41, 	"Mumbai"));
		employeeList.add(new Employee(002, 	"Virender", "Sehwag", 		36, 	"Najafgarh"));
		employeeList.add(new Employee(003, 	"Sourav",	"Ganguly", 		42, 	"Kolkata"));
		employeeList.add(new Employee(004, 	"Rahul", 	"Dravid", 		42, 	"Banglore"));
		employeeList.add(new Employee(005, 	"VVS", 		"Laxman", 		40, 	"Hyderabad"));
	}

	public List<Employee> getAllEmployees(){
		return employeeList;
	}

	public Employee getEmployeeById(String id) {
		Employee emp = null;
		Integer idToSearch = Integer.parseInt(id);
		for (Employee employee : employeeList) {
			if (idToSearch == employee.getEmployeeId()) {
				emp = employee;
				break;
			}
		}
		return emp;
	}

	public Employee getEmployeeByFirstName(String firstName){
		Employee emp = null;
		for (Employee employee : employeeList) {
			if (firstName.equalsIgnoreCase(employee.getEmpFirstName())) {
				emp = employee;
				break;
			}
		}
		return emp;
	}
	
	public Employee createEmployee(String id, String firstName, String lastName, String age, String city){
		Employee employee = new Employee(Integer.parseInt(id), firstName, lastName, Integer.parseInt(age), city);
		employeeList.add(employee);
		return employee;
	}
	
	public Employee updateEmployeeName(String id, String newFirstName, String newLastName){
		Employee emp = null;
		Integer idToSearch = Integer.parseInt(id);
		for(Employee employee : employeeList){
			if(idToSearch == employee.getEmployeeId()){
				employee.setEmpFirstName(newFirstName);
				employee.setEmpLastName(newLastName);
				emp = employee;
			}
		}
		return emp;
	}
	
	public Employee deleteEmployee(String id){
		Employee emp = null;
		Integer idToSearch = Integer.parseInt(id);
		for(Employee employee : employeeList){
			if(idToSearch == employee.getEmployeeId()){
				employeeList.remove(employee);
				emp = employee;
			}
		}
		return emp;
	}	
}
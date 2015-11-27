package com.rest.employees.app.to;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	private int employeeId;
	private String empFirstName;
	private String empLastName;
	private int age;
	private String city;
	
	public Employee() {
		super();
	}

	public Employee(int employeeId, String empFirstName, String empLastName,
			int age, String city) {
		this.employeeId = employeeId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.age = age;
		this.city = city;
	}
	
	@XmlAttribute 
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	@XmlElement 
	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	@XmlElement
	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	@XmlElement 
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@XmlElement 
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString(){
		return "Employee Details are: ID - " + employeeId + ", First Name -  "
				+ empFirstName + ", Last Name - " + empLastName + ", Age - " + age
				+ ", City - " + city;
	}
}
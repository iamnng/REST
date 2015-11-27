package com.rest.employee.app.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.rest.employee.app.service.EmployeeService;

public class EmployeeApplication extends Application{
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(EmployeeService.class);
		return classes;
	}
}
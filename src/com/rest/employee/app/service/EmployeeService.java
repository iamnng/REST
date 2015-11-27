package com.rest.employee.app.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.rest.employee.app.dao.EmployeeDao;
import com.rest.employees.app.to.Employee;

@Path("/")
public class EmployeeService{
	private EmployeeDao employeeDao = new EmployeeDao();
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String greetUser(){
		return "Hello, Welcome to our site !!";
	}

	// @PathParam Example
	// URL: http://localhost:8080/REST-EmployeeApp/employeeApp/employees/5
	// :\\d+ - Regex indicating that only numerics are accepted. Not sending
	// numeric results in 404 NOT FOUND exception.
	@GET
	@Path("/employees/{id:\\d+}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getEmployeeById(@PathParam("id") String id) {
		return employeeDao.getEmployeeById(id).toString();
	}

	// @QueryParam Example
	// @DefaultValue comes in picture of no query parameter is specified.
	// http://localhost:8080/REST-EmployeeApp/employeeApp/employees/search?fname=vvs
	@GET
	@Path("/employees/search")
	@Produces(MediaType.TEXT_PLAIN)
	public String getEmployeeByFirstName(@DefaultValue("Sachin") @QueryParam("fname") String firstName) {
		return employeeDao.getEmployeeByFirstName(firstName).toString();
	}
	
	// http://localhost:8080/REST-EmployeeApp/employeeApp/employees
	@GET
	@Path("/employees")
	public String getAllEmployees() {
		String result = "";
		List<Employee> employeeList = employeeDao.getAllEmployees();
		for(Employee employee : employeeList){
			result += "[" + employee.toString() + "]";
		}
		return result;
	}

	// @FormParam Example
	// POST Request to http://localhost:8080/REST-EmployeeApp/employeeApp/employees/add with following parameters as payload
	@POST
	@Path("/employees/add")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String createEmployee(@FormParam("id") String id,
			@FormParam("fname") String firstName,
			@FormParam("lname") String lastName, @FormParam("age") String age,
			@DefaultValue("No City") @FormParam("city") String city) {
		return employeeDao.createEmployee(id, firstName, lastName, age, city).toString();
	}
	
	@GET
	@Path("/employee/update")
	public String updateEmployeeName(@QueryParam("id") String id, @MatrixParam("fname") String firstName, @MatrixParam("lname") String lastName){
		Employee employee = employeeDao.updateEmployeeName(id, firstName, lastName);
		return employee.toString();
	}
	
	public String deleteEmployee(String id){
		Employee employee = employeeDao.deleteEmployee(id);
		return employee.toString();
	}
	
	@GET
	@Path("/example3/{empno : .+}/action/{action}")
	public String example3(
			@PathParam("empno") List<PathSegment> empnoSegment,
			@PathParam("action") String action) {
	
		for(PathSegment pathSegment : empnoSegment) {
			
			System.out.println("***" + pathSegment.getPath());
			MultivaluedMap<String, String> matrixParams = pathSegment.getMatrixParameters();
			for(String key : matrixParams.keySet()) {
				System.out.println(key + " : " + matrixParams.get(key));
			}
			
			System.out.println("Action" + action);
		}
		
		return "Response from example3";	
	}
	
	@GET
	@Path("/employees/xml/{id:\\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeeByIdXml(@PathParam("id") String id) {
		return employeeDao.getEmployeeById(id);
	}
	
	@GET
	@Path("/employees/res/{id:\\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeByIdResponse(@PathParam("id") String id) {
		ResponseBuilder builder = Response.ok(employeeDao.getEmployeeById(id));
		Response res = builder.build();
		return res;
	}
	
	// http://localhost:8080/REST-EmployeeApp/employeeApp/employees
	@GET
	@Path("/employees/xml")
	@Produces(MediaType.APPLICATION_XML)
	public Response getAllEmployeesXml() {
		List<Employee> employeeList = employeeDao.getAllEmployees();
		GenericEntity<List<Employee>> generic  = new GenericEntity<List<Employee>>(employeeList){};
		return Response.ok(generic).build();
	}
}

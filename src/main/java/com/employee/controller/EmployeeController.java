package com.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exception.ResourceNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

	@RestController
	public class EmployeeController 
	{
		  @Autowired
	    	private EmployeeRepository employeeRepository;
		
		  @CrossOrigin
		  @GetMapping("/employees") 
		  public List<Employee> getEmployee() 
		  {
			 return employeeRepository.findAll();
		  }
		  	@CrossOrigin
			@GetMapping("/employees/{employeeId}") 
			 public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") Integer employeeId) 
			{ 
				Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("employee not exist with employeeId: " + employeeId));
				return ResponseEntity.ok(employee);
			}
			@CrossOrigin
			@PostMapping("/employees") 
			 public Employee addEmployee(@RequestBody Employee employee) 
			 { 
				 return employeeRepository.save(employee); 
			 }
			
			 @CrossOrigin
			 @DeleteMapping("/employees/{employeeId}") 
			 public 	ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable("employeeId") Integer employeeId) 
			 {
				 Employee employee = employeeRepository.findById(employeeId)
							.orElseThrow(() -> new ResourceNotFoundException("employee not exist with employeeId: " + employeeId));
				 
				 employeeRepository.delete(employee);
				 Map<String, Boolean> response = new HashMap<>();
				 response.put("deleted",Boolean.TRUE);
				 return ResponseEntity.ok(response);
			 }
			@CrossOrigin
			@PutMapping("/employees/{employeeId}") 
			public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") Integer employeeId, @RequestBody Employee employeeDetails) 
			 {
				Employee employee = employeeRepository.findById(employeeId)
						.orElseThrow(() -> new ResourceNotFoundException("employee not exist with employeeId: " + employeeId));
				
				employee.setEmployeeEmailId(employeeDetails.getEmployeeEmailId());
				employee.setEmployeePassword(employeeDetails.getEmployeePassword());
				employee.setEmployeeAge(employeeDetails.getEmployeeAge());
				employee.setEmployeeFirstName(employeeDetails.getEmployeeFirstName());
				employee.setEmployeeLastName(employeeDetails.getEmployeeLastName());
				employee.setEmployeeDepartment(employeeDetails.getEmployeeDepartment());
				
				Employee updateemployee=employeeRepository.save(employee);
				return ResponseEntity.ok(updateemployee);
			 
			 }
}
		  


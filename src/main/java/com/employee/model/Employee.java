package com.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeeinfo")
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeid")
	private Integer employeeId;
	
	@Column(name = "employeeemailid")
	private String employeeEmailId;
	
	@Column(name = "employeepassword")
	private String employeePassword;
	
	@Column(name = "employeeage")
	private Integer employeeAge;
	
	@Column(name = "employeefirstname")
	private String employeeFirstName;
	
	@Column(name = "employeelastname")
	private String employeeLastName;
	
	@Column(name = "employeedepartment")
    private String employeeDepartment;
	
	public Employee() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String employeeEmailId, String employeePassword,
			Integer employeeAge, String employeeFirstName,
			String employeeLastName, String employeeDepartment) 
	{
		super();
		this.employeeEmailId = employeeEmailId;
		this.employeePassword = employeePassword;
		this.employeeAge= employeeAge;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeeDepartment = employeeDepartment;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeEmailId() {
		return employeeEmailId;
	}
	public void setEmployeeEmailId(String employeeEmailId) {
		this.employeeEmailId = employeeEmailId;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public Integer getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(Integer employeeAge) {
		this.employeeAge = employeeAge;
	}
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	public String getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	@Override
	public String toString() 
	{
		return "Employee [employeeId=" + employeeId + ", employeeEmailId=" + employeeEmailId + ", employeePassword="
				+ employeePassword +", employeeAge=" + employeeAge + ", employeeFirstName=" + employeeFirstName + ", employeeLastName="
				+ employeeLastName + ", employeeDepartment=" + employeeDepartment + "]";
	
	}

}

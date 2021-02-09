package com.accenture.lkm.model;

public class Employee {
	private String empoloyeeName;
	private Integer employeeId;
	private double salary;
	private Integer departmentCode;

	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String empoloyeeName, Integer employeeId, double salary,
			Integer departmentCode) {
		super();
		this.empoloyeeName = empoloyeeName;
		this.employeeId = employeeId;
		this.salary = salary;
		this.departmentCode = departmentCode;
	}

	public String getEmpoloyeeName() {
		return empoloyeeName;
	}

	public void setEmpoloyeeName(String empoloyeeName) {
		this.empoloyeeName = empoloyeeName;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Integer getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(Integer departmentCode) {
		this.departmentCode = departmentCode;
	}

	@Override
	public String toString() {
		return "Employee [empoloyeeName=" + empoloyeeName + ", employeeId="
				+ employeeId + ", salary=" + salary + ", departmentCode="
				+ departmentCode + "]";
	}
	
	
}

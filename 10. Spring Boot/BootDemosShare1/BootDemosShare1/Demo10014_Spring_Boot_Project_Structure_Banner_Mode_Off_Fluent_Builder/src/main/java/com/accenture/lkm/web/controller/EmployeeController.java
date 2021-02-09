package com.accenture.lkm.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.bussiness.bean.Employee;
import com.accenture.lkm.dao.EmployeeDAO;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@RequestMapping(value = "emp/controller/getDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmployeeDetails() {
		List<Employee> listEmployee = new ArrayList<Employee>(employeeDAO.getAllEmployee());
		
		return new ResponseEntity<List<Employee>>(listEmployee,HttpStatus.OK);
	}

	@RequestMapping(value = "emp/controller/getDetailsById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeDetailByEmployeeId(@PathVariable("id") int myId) {
		Employee employee = employeeDAO.getEmployeeDetailsById(myId);

		if (employee != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/emp/controller/addEmp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		int count=employeeDAO.addEmployee(employee);
		return new ResponseEntity<String>("Employee added successfully with id:" + count,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/emp/controller/updateEmp", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@RequestBody  Employee employee) {
		System.out.println(">>>"+employee);
		if (employeeDAO.getEmployeeDetailsById(employee.getEmployeeId()) == null) {
			Employee employee2 = null;
			return new ResponseEntity<Employee>(employee2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Employee updated = employeeDAO.updateEmployee(employee);
		return new ResponseEntity<Employee>(updated, HttpStatus.OK);
	}

	@RequestMapping(value = "/emp/controller/deleteEmp/{id}", method = RequestMethod.DELETE,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int myId) {
		if (employeeDAO.getEmployeeDetailsById(myId) == null) {
			Employee employee2 = null;
			return new ResponseEntity<Employee>(employee2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Employee employee = employeeDAO.removeEmployee(myId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
}
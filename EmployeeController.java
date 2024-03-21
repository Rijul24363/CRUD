package com.cf.manipal.arch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cf.manipal.arch.entity.Employee;
import com.cf.manipal.arch.repository.EmployeeRepository;
import com.cf.manipal.arch.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/create")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceInterface employeeserviceinterface;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee employeesave = employeeserviceinterface.addEmployee(employee);
		return new ResponseEntity<Employee>(employeesave, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getEmployee(){
		List<Employee> listofEmployees = employeeserviceinterface.getEmployee();
		return new ResponseEntity<List<Employee>>(listofEmployees, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{empid}")
	public ResponseEntity<Void> deleteEmpById(@PathVariable("empid") Long empidLong){
		employeeserviceinterface.deleteEmpById(empidLong);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee employeeupdate = employeeserviceinterface.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeupdate, HttpStatus.CREATED);
		
	}
	
	

}

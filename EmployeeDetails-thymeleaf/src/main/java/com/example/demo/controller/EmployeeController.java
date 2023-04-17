package com.example.demo.controller;

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

import com.example.demo.model.EmployeeModel;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController
{
	@Autowired
	private EmployeeService empService;
	
	
	@GetMapping("/get")
	public List<EmployeeModel> getData()
	{
		return empService.getData();
	}
	
	@PostMapping("/add")
	public EmployeeModel addData(@RequestBody EmployeeModel emp)
	{
		return empService.addData(emp);
	}
	
	@PutMapping("/update")
	public EmployeeModel updateData(@RequestBody EmployeeModel emp)
	{
		return empService.updateData(emp);
	}
	
	@DeleteMapping("/deleted/{id}")
	public  ResponseEntity<String> deleteEmp(@PathVariable("id")Integer  id)
	{
		empService.deleteEmp(id);
		 return  new ResponseEntity<String>("record delete",HttpStatus.OK);
	}
}

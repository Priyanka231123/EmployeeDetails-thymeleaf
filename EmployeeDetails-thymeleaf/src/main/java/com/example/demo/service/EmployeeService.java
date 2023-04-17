package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepo empRepo;
	
	// Get the List of employee
	 public List<EmployeeModel > getAllEmployees()
	 {
	    List<EmployeeModel> list =  (List<EmployeeModel>)empRepo.findAll();
	    return list;
	 }
	 
	 // Get employee By keyword
	 public List<EmployeeModel > getByKeyword(String keyword)
	 {
	    return empRepo.findByKeyword(keyword);
	 }
	 
	 //Get Employee by Id
	 public EmployeeModel getEmployeeById(Integer id) throws RecordNotFoundException
	 {
		  Optional<EmployeeModel> employeeModel= empRepo.findById(id);
		  if(employeeModel!=null)
		  {
		    return employeeModel.get();
		  }
		  else
		  {
		    throw new RecordNotFoundException("Not found");
		  }
	 }
			 
    //Save data into database
	 public EmployeeModel saveOrUpdateData(EmployeeModel  employeeModel) 
	 {
		  if( employeeModel.getId() == null)
		  {
			return empRepo.save( employeeModel);
		  }
		  else 
		  {
		     Optional<EmployeeModel> sOptional = empRepo.findById(employeeModel.getId());
			 if(sOptional!=null)
			 {
				   EmployeeModel  employeeModel2 = sOptional.get();
				   employeeModel2.setEmpEmail( employeeModel.getEmpEmail());
				   employeeModel2.setEmpMobile( employeeModel.getEmpMobile());
				   employeeModel2.setAddress( employeeModel.getAddress());
				   employeeModel2=empRepo.save( employeeModel2);
			       return  employeeModel2;
			  }
			  else 
			  {
				   employeeModel = empRepo.save( employeeModel);
			       return  employeeModel;
			   }
		  }
	  }
	    
	
	public List<EmployeeModel> getData()
	{
		return empRepo.findAll();
		
	}
	
	public EmployeeModel addData( EmployeeModel emp)
	{
		return empRepo.save(emp);
	}
	
	public EmployeeModel updateData(EmployeeModel emp)
	{
		return empRepo.save(emp);
	}
	
	public void deleteEmp(Integer id)
	{
		 empRepo.deleteById(id);
		
		
	}

}

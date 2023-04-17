package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.EmployeeModel;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.service.EmployeeService;


@Controller
public class IndexController
{
	
	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private EmployeeService empService;
	
	//view the form
	  @GetMapping("/getData")
	  public String index()
	  {
		 return "home";
    }
	
	  //add the form 
	  @PostMapping("/register")
	  public String userRegistration(@ModelAttribute EmployeeModel employeeModel, Model model)
	  {
		System.out.println(employeeModel.toString());
		//validate
		
		System.out.println(employeeModel.getId());
		System.out.println(employeeModel.getEmpName());
		System.out.println(employeeModel.getEmpEmail());
		System.out.println(employeeModel.getEmpMobile());
		System.out.println(employeeModel.getAddress());
		System.out.println(employeeModel.getState());
		System.out.println(employeeModel.getCity());
		
		EmployeeModel user_inserted =  empRepo.save(employeeModel);
      return "sucess";
	   }
	  
	  //if the keyword is null the getAllEmployees() method of the Service class will be invoked 
	  //else getByKeyword() method would be invoked.
	  //search
	  @RequestMapping(path = {"/","/search"})
	   public String data(EmployeeModel employeeModel, Model model, String keyword)
	   {
		  if(keyword!=null)
		  {
		    List<EmployeeModel> list = empService.getByKeyword(keyword);
		    model.addAttribute("list", list);
		   }else
		   {
		    List<EmployeeModel> list = empService.getAllEmployees();
		    model.addAttribute("list", list);
		   }
		   return "index";
	    }
	  
	 //curd operation view employee
	  @GetMapping("/")
	  public String data1(EmployeeModel employeeModel1, Model model1)
	  {
	   List< EmployeeModel> list = empService.getAllEmployees();
	   model1.addAttribute("list", list);
	   return "index";
	  }
   
    //curd operation: add data
	  @GetMapping("/add")
	  public String showAddForm(EmployeeModel employeeModel, Model model)
	  {
	   return "add-data";
	  }
	  
	  //save data
	  @PostMapping("/save")
	  public String create(EmployeeModel employeeModel, Model model) 
	  {
	   empService.saveOrUpdateData(employeeModel);
	   return "redirect:/";
	  }
	
	  
	  //add employee by 1
	  @RequestMapping(path = { "/update","/update/{id}"})
	  public String update(Model model,@PathVariable("id") Integer id) throws RecordNotFoundException
	  {
	     if(id!=null)
	     {
		    EmployeeModel employeeModel2= empService.getEmployeeById(id);
	        model.addAttribute("employeeModel", employeeModel2);
	     }else
	     {
	        model.addAttribute("employeeModel", new    EmployeeModel());
	     }
	      return "add-data";
	  }
	  
	  
}

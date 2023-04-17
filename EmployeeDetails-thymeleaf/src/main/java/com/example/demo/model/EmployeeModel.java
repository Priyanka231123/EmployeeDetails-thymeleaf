package com.example.demo.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeModel 
{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	// @NotBlank(message="employee name can not be empty!!")
	 //@Size(min=2,max=15,message="please enter correct name")
	 private String empName;
	 
	// @NotEmpty(message="email id shouldn't be null")
	 //@Email(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	 private String empEmail;
	 
	// @NotBlank(message="mobile number must be not empty")
	// @Size(min=10,max=10,message="please enter correct mobile number")
	 private String empMobile;
	 
	// @NotBlank(message="address must be not empty")
	 private String address;
	 
	// @NotBlank(message="state must be not empty")
	 private String state;
	 
	// @NotBlank(message="city must be not empty")
	 private String city;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpMobile() {
		return empMobile;
	}

	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public EmployeeModel(Integer id, String empName, String empEmail, String empMobile, String address, String state,
			String city) {
		super();
		this.id = id;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empMobile = empMobile;
		this.address = address;
		this.state = state;
		this.city = city;
	}

	public EmployeeModel() {
		super();
	}

	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", empName=" + empName + ", empEmail=" + empEmail + ", empMobile="
				+ empMobile + ", address=" + address + ", state=" + state + ", city=" + city + "]";
	}

	
	
	
	 
}

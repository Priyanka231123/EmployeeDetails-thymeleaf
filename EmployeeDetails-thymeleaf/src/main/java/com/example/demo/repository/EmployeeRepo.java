package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EmployeeModel;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeModel,Integer>
{
	//Custom query
		 @Query(value = "select * from employee emp where emp_name like %:keyword% or id like %:keyword%", nativeQuery = true)
		 List<EmployeeModel> findByKeyword(@Param("keyword") String keyword);
}

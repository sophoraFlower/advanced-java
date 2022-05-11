package com.mialab.OneToOne_demo.mapper;

import com.mialab.OneToOne_demo.domain.Employee;

public interface EmployeeMapper {

	Employee selectEmployeeById(String id);
	
}
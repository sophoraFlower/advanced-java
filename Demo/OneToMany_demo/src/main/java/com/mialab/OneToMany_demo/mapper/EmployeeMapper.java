package com.mialab.OneToMany_demo.mapper;

import com.mialab.OneToMany_demo.domain.Employee;

public interface EmployeeMapper {

	Employee selectEmployeeById(String emp_no);
	
}
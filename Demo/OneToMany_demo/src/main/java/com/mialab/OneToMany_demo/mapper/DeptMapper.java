package com.mialab.OneToMany_demo.mapper;

import com.mialab.OneToMany_demo.domain.Dept;

public interface DeptMapper {

	Dept selectDeptById(String dept_id);
	
}

package com.mialab.mybatis_first_demo.mapper;

import com.mialab.mybatis_first_demo.domain.Student;

public interface StudentMapper {
	public Student getStudent(String sno);
}
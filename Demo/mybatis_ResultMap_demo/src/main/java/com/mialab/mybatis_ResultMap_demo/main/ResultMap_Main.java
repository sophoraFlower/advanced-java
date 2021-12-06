package com.mialab.mybatis_ResultMap_demo.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.mialab.mybatis_ResultMap_demo.domain.Student;
import com.mialab.mybatis_ResultMap_demo.mapper.StudentMapper;
import com.mialab.mybatis_ResultMap_demo.utils.DBOperatorMgr;

public class ResultMap_Main {
	
	public static void main(String[] args) {
		testResultMap();
	}	

	private static void testResultMap() {
		Logger log = Logger.getLogger(ResultMap_Main.class);
		SqlSession session = null;
		try {
			session = DBOperatorMgr.getInstance().getSqlSessionFactory().openSession();
			com.mialab.mybatis_ResultMap_demo.mapper.StudentMapper mapper = session.getMapper(StudentMapper.class);			
			List<Student> stu_list = mapper.getStudentAll();
			for(Student stu:stu_list) {
				log.info(stu);
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}		
	}

}

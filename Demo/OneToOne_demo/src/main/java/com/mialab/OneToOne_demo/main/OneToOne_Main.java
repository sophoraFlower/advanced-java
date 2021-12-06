package com.mialab.OneToOne_demo.main;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.mialab.OneToOne_demo.domain.Employee;
import com.mialab.OneToOne_demo.mapper.EmployeeMapper;
import com.mialab.OneToOne_demo.utils.DBOperatorMgr;

public class OneToOne_Main {

	public static void main(String[] args) {
		System.out.println("Hello");
		testSelect("HW9803");
	}
	
	private static void testSelect(String emp_no) {
		Logger log = Logger.getLogger(OneToOne_Main.class);
		SqlSession session = null;
		try {
			session = DBOperatorMgr.getInstance().getSqlSessionFactory().openSession();
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Employee employee = mapper.selectEmployeeById(emp_no);
			System.out.println(employee);
			log.info(employee);
			log.info(employee.getEmployeeSchool());
			
		} finally {
			if (session != null) {
				session.close();
			}
		}		
	}
	

}

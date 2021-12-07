package com.mialab.OneToMany_demo.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.mialab.OneToMany_demo.domain.Dept;
import com.mialab.OneToMany_demo.domain.Employee;
import com.mialab.OneToMany_demo.mapper.DeptMapper;
import com.mialab.OneToMany_demo.mapper.EmployeeMapper;
import com.mialab.OneToMany_demo.utils.DBOperatorMgr;

public class OneToMany_Main {

	public static void main(String[] args) {
		//System.out.println("This is a test!");
		//测试一对多
		testSelectDeptById("101");
		//测试多对一
		testSelectEmployeeById("HW9803");
	}	

	private static void testSelectDeptById(String dept_id) {
		Logger log = Logger.getLogger(OneToMany_Main.class);
		SqlSession session = null;
		try {
			session = DBOperatorMgr.getInstance().getSqlSessionFactory().openSession();
			DeptMapper mapper = session.getMapper(DeptMapper.class);
			Dept dept = mapper.selectDeptById(dept_id);
			//System.out.println(dept);
			log.info(dept);
			// log.info(dept.getEmployees());
			List<Employee> employees = dept.getEmployees();
			for(Employee employee : employees) {
				System.out.println(employee);
				//log.info(employee);
			}

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
	
	private static void testSelectEmployeeById(String emp_no) {
		Logger log = Logger.getLogger(OneToMany_Main.class);
		SqlSession session = null;
		try {
			session = DBOperatorMgr.getInstance().getSqlSessionFactory().openSession();
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Employee employee = mapper.selectEmployeeById(emp_no);
			//System.out.println(employee);
			log.info(employee);
			log.info(employee.getDept());
			
		} finally {
			if (session != null) {
				session.close();
			}
		}		
	}
}
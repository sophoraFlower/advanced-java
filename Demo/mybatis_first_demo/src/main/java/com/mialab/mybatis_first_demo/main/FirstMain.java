package com.mialab.mybatis_first_demo.main;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

import com.mialab.mybatis_first_demo.domain.Student;
import com.mialab.mybatis_first_demo.mapper.StudentMapper;

public class FirstMain {
	private static SqlSessionFactory sqlSessionFactory;
	public static void main(String[] args) {
		SqlSession session = null;
		try {
			// 读取 mybatis-config.xml
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			// 初始化 Mybatis, 创建 SqlSessionFactory 类的实例
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 创建 Session 实例
			session = sqlSessionFactory.openSession();
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			Student student = mapper.getStudent("20171509");
			System.out.println(student);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) {
				session.close();
			}
		}
	}

}

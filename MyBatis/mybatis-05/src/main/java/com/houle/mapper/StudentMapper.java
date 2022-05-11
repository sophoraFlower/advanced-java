package com.houle.mapper;

import com.houle.pojo.Student;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    // 获取所有学生以及对应老师的信息
    List<Student> getStudent();

    // 获取所以学生信息
    List<Student> getStudentsByLimit(Map<String, Integer> map);

    // 使用RowBounds实现分页
    List<Student> getStudentsByRowBounds(RowBounds rowBounds);
}

package com.houle.mapper;

import com.houle.pojo.Teacher;

public interface TeacherMapper {
    // @Select("select * from teacher where id = #{tid}")
    // Teacher getTeacher(@Param("tid") int id);
    // 获取指定老师，及老师下的所有学生
    Teacher getTeacher(int id);
}

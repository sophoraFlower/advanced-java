import com.houle.mapper.StudentMapper;
import com.houle.mapper.TeacherMapper;
import com.houle.pojo.Student;
import com.houle.pojo.Teacher;
import com.houle.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {

    @Test
    public void testGetStudentsByLimit() {
        SqlSession session = MybatisUtils.getSession(false);
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 2);
        map.put("pageSize", 4);
        List<Student> students = mapper.getStudentsByLimit(map);

        for (Student student : students){
            System.out.println("学生名: "+ student.getName());
        }
    }

    @Test
    public void testGetStudentsByRowBounds() {
        SqlSession session = MybatisUtils.getSession(false);
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        int currentPage = 2;  // 第几页
        int pageSize = 4;  // 每页显示几个
        RowBounds rowBounds = new RowBounds((currentPage-1)*pageSize,pageSize);

        List<Student> students = mapper.getStudentsByRowBounds(rowBounds);

        for (Student student : students){
            System.out.println("学生名: "+ student.getName());
        }
    }

    @Test
    public void testGetTeacher(){
        SqlSession session = MybatisUtils.getSession(false);
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacher(2);
        System.out.println(teacher);
    }

    @Test
    public void testGetStudent() {
        SqlSession session = MybatisUtils.getSession(false);
        StudentMapper teacherMapper = session.getMapper(StudentMapper.class);
        List<Student> list = teacherMapper.getStudent();

        for (Student student: list
             ) {
            System.out.println(student);
        }

    }

}

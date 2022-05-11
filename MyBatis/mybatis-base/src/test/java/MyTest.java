import com.houle.dao.UserDao;
import com.houle.pojo.User;
import com.houle.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {

    @Test
    public void selectUser() {
        SqlSession session = MybatisUtils.getSession();
        // 方法一:
        // List<User> users = session.selectList("com.kuang.mapper.UserMapper.selectUser");
        // 方法二:
        UserDao mapper = session.getMapper(UserDao.class);
        List<User> users = mapper.selectUser();

        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void selectUserById() {
        SqlSession session = MybatisUtils.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        int id = 2;
        User user = mapper.selectUserById(id);
        System.out.println(user);
        session.close();
    }

    @Test
    public void selectUserByName() {
        SqlSession session = MybatisUtils.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        String name = "张三";
        User user = mapper.selectUserByName(name);
        System.out.println(user);
        session.close();
    }

    @Test
    public void selectUserByNP() {
        SqlSession session = MybatisUtils.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        String name = "张三";
        String pwd = "abcdef";
        User user = mapper.selectUserByNP(name, pwd);
        System.out.println(user);
        session.close();
    }

    @Test
    public void selectUserByNP2() {
        SqlSession session = MybatisUtils.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username","李四");
        map.put("pwd","987654");
        User user = mapper.selectUserByNP2(map);
        System.out.println(user);
        session.close();
    }

    @Test
    public void testAddUser() {
        SqlSession session = MybatisUtils.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User user = new User(5, "王五", "abcff");
        int i = mapper.addUser(user);
        System.out.println(i);
        session.commit(); // 提交事务,重点!不写的话不会提交到数据库
        session.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSession session = MybatisUtils.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User user = mapper.selectUserById(1);
        user.setPwd("a666666");
        int i = mapper.updateUser(user);
        System.out.println(i);
        session.commit(); // 提交事务,重点!不写的话不会提交到数据库
        session.close();
    }

    @Test
    public void testDeleteUser() {
        SqlSession session = MybatisUtils.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User user = mapper.selectUserById(5);
        int i = mapper.deleteUser(user);
        System.out.println(i);
        session.commit(); // 提交事务,重点!不写的话不会提交到数据库
        session.close();
    }

}

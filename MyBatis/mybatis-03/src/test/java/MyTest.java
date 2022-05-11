import com.houle.dao.UserDao;
import com.houle.pojo.User;
import com.houle.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class MyTest {

    static Logger logger = Logger.getLogger(MyTest.class);
    @Test
    public void testSelectUserById() {
        SqlSession session = MybatisUtils.getSession();  // 获取SqlSession连接
        UserDao mapper = session.getMapper(UserDao.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
        session.close();
    }


    @Test
    public void selectUser() {
        logger.info("info：进入selectUser方法");
        logger.debug("debug：进入selectUser方法");
        logger.error("error: 进入selectUser方法");
        SqlSession session = MybatisUtils.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        List<User> users = mapper.selectUser();
        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }

}

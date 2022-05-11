import com.houle.dao.UserDao;
import com.houle.pojo.User;
import com.houle.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void selectUserById() {
        SqlSession session = MybatisUtils.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        int id = 2;
        User user = mapper.selectUserById(id);
        System.out.println(user);
        session.close();
    }
}

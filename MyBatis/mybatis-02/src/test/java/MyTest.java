import com.houle.dao.UserDao;
import com.houle.pojo.User;
import com.houle.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void test() {
        // 从会话中获取映射器
        SqlSession session = MybatisUtils.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User user = mapper.selectUser(1);
        System.out.println(user);
        session.close();
    }
}

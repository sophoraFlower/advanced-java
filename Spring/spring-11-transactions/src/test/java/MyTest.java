import com.houle.mapper.UserMapper;
import com.houle.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = (UserMapper) context.getBean("userDao");
        List<User> user = mapper.selectUser();
        System.out.println(user);
    }
}

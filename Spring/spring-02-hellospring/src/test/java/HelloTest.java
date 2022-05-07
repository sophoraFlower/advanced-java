import com.houle.dao.impl.UserDaoMySqlImpl;
import com.houle.dao.impl.UserDaoOracleImpl;
import com.houle.pojo.Hello;
import com.houle.pojo.User;
import com.houle.service.UserService;
import com.houle.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

    @Test
    public void test(){
        // 解析beans.xml文件, 生成管理相应的Bean对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // getBean: 参数即为spring配置文件中bean的id .
        Hello hello = context.getBean("hello", Hello.class);
        hello.show();
    }

    @Test
    public void test2(){
        UserService service = new UserServiceImpl();
        service.getUser();

        UserServiceImpl service2 = new UserServiceImpl();
        service2.setUserDao( new UserDaoMySqlImpl() );
        service2.getUser();
        //那又想用Oracle去实现呢
        service2.setUserDao( new UserDaoOracleImpl() );
        service2.getUser();
    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //在执行getBean的时候, user已经创建好了 , 通过无参构造
        User user = context.getBean("user", User.class);
        //调用对象的方法 .
        user.show();
    }

}

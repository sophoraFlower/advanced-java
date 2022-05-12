import cn.osxm.ssmi.dao.HelloDao;
import cn.osxm.ssmi.pojo.User;
import cn.osxm.ssmi.service.HelloService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean("user", User.class);
        user.setUsername("Zhang San");
        System.out.println(user.getUsername());
    }

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloService helloService = context.getBean("helloService", HelloService.class);
        String name = "houle";
        HelloDao helloDao = new HelloDao();
        helloService.sayHello();
        helloService.setName(name);
        helloService.setHelloDao(helloDao);
        System.out.println(helloService.getName());
        helloService.getHelloDao().insert();
    }
}

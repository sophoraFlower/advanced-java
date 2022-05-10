import com.houle.config.MyConfig;
import com.houle.pojo.Dog;
import com.houle.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationCOntext.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user.name);
    }

    @Test
    public void test2(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        Dog dog = applicationContext.getBean("dog", Dog.class);
        System.out.println(dog.name);
    }

}

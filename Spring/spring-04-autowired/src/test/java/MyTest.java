import com.houle.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void testMethodAutowire() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = context.getBean("user", User.class);
        user.getCat().shout();
        user.getDog().shout();

        User user2 = context.getBean("user", User.class);
        user2.getCat().shout();
        user2.getDog().shout();
    }

}

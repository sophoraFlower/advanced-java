import com.houle.pojo.Student;
import com.houle.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = context.getBean("user", User.class);
        user.show();

        User user1 = context.getBean("user1", User.class);
        user1.show();

        User user2 = context.getBean("user2", User.class);
        user2.show();
    }

    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student.getName());  // 小明

        Student student1 = context.getBean("student1", Student.class);
        System.out.println(student1.getName());  // 小明
        System.out.println(student1.getAddress().getAddress());  // 重庆

        Student student2 = context.getBean("student2", Student.class);
        System.out.println(student1.getName());  // 小明
        System.out.println(student1.getAddress().getAddress());  // 重庆
        for (String book: student2.getBooks()
             ) {
            System.out.println(book);
        }
        student2.show();
    }

    @Test
    public void test02() {
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user  = context.getBean("p-namespace", User.class);
        user.show();
    }

}

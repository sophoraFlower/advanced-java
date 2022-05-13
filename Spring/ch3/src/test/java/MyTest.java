import cn.osxm.ssmi.service.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static cn.osxm.ssmi.service.OuterClass.*;

public class MyTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        OuterClass outerClass = applicationContext.getBean("outerObject", OuterClass.class);
        outerClass.outerMethod();
        OuterClass.InnerClass innerClass = applicationContext.getBean("innerObject", InnerClass.class);
        innerClass.innerMethod();
    }

    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StaticFactoryService service = applicationContext.getBean("staticFactoryService", StaticFactoryService.class);
        StaticFactoryService service1 = StaticFactoryService.getInstance();
        System.out.println(service.equals(service1));  // true
    }

    @Test
    public void test2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Foo foo = applicationContext.getBean("foo", Foo.class);
        Foo2 foo2 = applicationContext.getBean("foo2", Foo2.class);
        InstanceFactory instanceFactory = applicationContext.getBean("instanceFactory", InstanceFactory.class);
        foo.foo();
        foo2.foo();
        instanceFactory.getFooInstance().foo();
        instanceFactory.getFoo2Instance().foo();

        Foo foo_1 = new InstanceFactory().getFooInstance();
        foo_1.foo();
        Foo2 foo_2 = new InstanceFactory().getFoo2Instance();
        foo_2.foo();
    }

}

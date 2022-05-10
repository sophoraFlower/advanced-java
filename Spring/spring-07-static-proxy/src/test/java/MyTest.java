import com.houle.service.JdkProxyFactory;
import com.houle.service.SmsService;
import com.houle.service.impl.SmsServiceImpl;
import com.houle.service.impl.SmsServicePlusImpl;
import com.houle.service.proxy.SmsServiceProxy;
import org.junit.Test;

public class MyTest {

    @Test
    public void test() {
        SmsService service = new SmsServiceImpl();
        SmsServiceProxy proxy = new SmsServiceProxy(service);
        proxy.send("hello SH");

        SmsService service1 = new SmsServicePlusImpl();
        SmsServiceProxy proxy1 = new SmsServiceProxy(service1);
        proxy1.send("Hello SH Plus");
    }

    @Test
    public void test1() {
        SmsService service = new SmsServiceImpl();
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(service);
        smsService.send("动态代理");
    }

}

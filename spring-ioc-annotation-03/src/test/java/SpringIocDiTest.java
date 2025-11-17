import com.atguigu.ioc_03.Controller.StudentController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocDiTest {
    @Test
    public void IoCTest(){
        ApplicationContext applicationContext1 =
                new ClassPathXmlApplicationContext("spring-03.xml");

        StudentController studentController = applicationContext1.getBean(StudentController.class);

        studentController.findAll();
    }
}

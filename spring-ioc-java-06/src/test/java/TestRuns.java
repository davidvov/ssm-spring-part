import com.atguigu.Controller.StudentController;
import com.atguigu.JavaConfig.JavaConfiguration;
import com.atguigu.pojo.Student;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestRuns {
    @Test
    public void testRun(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(JavaConfiguration.class);
        StudentController studentController = applicationContext.getBean(StudentController.class);
        studentController.findAll();
    }
}

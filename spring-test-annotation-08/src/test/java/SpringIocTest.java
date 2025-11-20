import com.atguigu.Components.A;
import com.atguigu.Components.B;
import com.atguigu.Config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfig.class)
public class SpringIocTest {

    @Autowired
    private A a;

    @Autowired
    private B b;
    @Test
    public void test(){
        System.out.println(a);
        System.out.println("b = " + b);
    }
}

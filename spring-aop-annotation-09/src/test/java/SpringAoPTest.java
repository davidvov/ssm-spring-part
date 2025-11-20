import com.atguigu.Config.JavaConfig;
import com.atguigu.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig(value = JavaConfig.class)
public class SpringAoPTest {
    @Autowired
    private Calculator caculator;

    @Test
    public void runTest(){
        int add = caculator.add(1,1);
        System.out.println("caculator = " + add);

        int mul = caculator.mul(2, 3);
        System.out.println("mul = " + mul);
    }
}

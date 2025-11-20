import com.atguigu.config.JavaConfig;
import com.atguigu.service.StudentService;
import com.atguigu.service.TopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.FileNotFoundException;

@SpringJUnitConfig(JavaConfig.class)
public class SpingTxTest {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TopService topService;

    @Test
    public void test() throws FileNotFoundException {
        topService.topService();
    }
}

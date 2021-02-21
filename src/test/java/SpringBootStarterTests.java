import com.priceengine.controller.PriceEngineController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(controllers = PriceEngineController.class)
public class SpringBootStarterTests {

    @Test
    public void contextLoads() {
    }

}
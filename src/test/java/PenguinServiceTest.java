import com.priceengine.dto.response.CalculationResponse;
import com.priceengine.entity.Penguin;
import com.priceengine.service.PenguinEarsService;
import com.priceengine.service.PenguinEarsServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class PenguinServiceTest {

    @Configuration
    static class ContextConfiguration {

        @Bean
        public PenguinEarsService penguinEarsService() {
            PenguinEarsService penguinEarsService = new PenguinEarsServiceImpl();
            return penguinEarsService;
        }
    }

    @Autowired
    private PenguinEarsService penguinEarsService;

    @Test
    public void testPenguinService1() throws Exception {

        Penguin penguin = new Penguin();
        penguin.setCustomerId("99x-121212");

        penguin.setNumberOfSingleUnits(1);
        CalculationResponse calculationResponse1 = penguinEarsService.calculatePenguinPrice(penguin);
        Assert.assertEquals(calculationResponse1.getTotalPrice(), 11.375, 0.0f);
        Assert.assertEquals(calculationResponse1.getCustomerId(), "99x-121212");

    }

    @Test
    public void testPenguinService2() throws Exception {
        Penguin penguin = new Penguin();
        penguin.setCustomerId("99x-121212");

        penguin.setNumberOfSingleUnits(2);
        CalculationResponse calculationResponse2 = penguinEarsService.calculatePenguinPrice(penguin);
        Assert.assertEquals(calculationResponse2.getTotalPrice(), 22.75, 0.0f);
        Assert.assertEquals(calculationResponse2.getCustomerId(), "99x-121212");

    }

    @Test
    public void testPenguinService3() throws Exception {
        Penguin penguin = new Penguin();
        penguin.setCustomerId("99x-121212");

        penguin.setNumberOfSingleUnits(3);
        CalculationResponse calculationResponse3 = penguinEarsService.calculatePenguinPrice(penguin);
        Assert.assertEquals(calculationResponse3.getTotalPrice(), 34.125, 0.0f);
        Assert.assertEquals(calculationResponse3.getCustomerId(), "99x-121212");

    }

    @Test
    public void testPenguinService4() throws Exception {
        Penguin penguin = new Penguin();
        penguin.setCustomerId("99x-121212");

        penguin.setNumberOfSingleUnits(4);
        CalculationResponse calculationResponse4 = penguinEarsService.calculatePenguinPrice(penguin);
        Assert.assertEquals(calculationResponse4.getTotalPrice(), 45.5, 0.0f);
        Assert.assertEquals(calculationResponse4.getCustomerId(), "99x-121212");

    }

    @Test
    public void testPenguinService5() throws Exception {
        Penguin penguin = new Penguin();
        penguin.setCustomerId("99x-121212");

        penguin.setNumberOfSingleUnits(5);
        CalculationResponse calculationResponse5 = penguinEarsService.calculatePenguinPrice(penguin);
        Assert.assertEquals(calculationResponse5.getTotalPrice(), 56.875, 0.0f);
        Assert.assertEquals(calculationResponse5.getCustomerId(), "99x-121212");

    }

    @Test
    public void testPenguinService20() throws Exception {
        Penguin penguin = new Penguin();
        penguin.setCustomerId("99x-121212");

        penguin.setNumberOfSingleUnits(20);
        CalculationResponse calculationResponse20 = penguinEarsService.calculatePenguinPrice(penguin);
        Assert.assertEquals(calculationResponse20.getTotalPrice(), 175, 0.0f);
        Assert.assertEquals(calculationResponse20.getCustomerId(), "99x-121212");

    }

    @Test
    public void testPenguinService40() throws Exception {
        Penguin penguin = new Penguin();
        penguin.setCustomerId("99x-121212");

        penguin.setNumberOfSingleUnits(40);
        CalculationResponse calculationResponse40 = penguinEarsService.calculatePenguinPrice(penguin);
        Assert.assertEquals(calculationResponse40.getTotalPrice(), 350, 0.0f);
        Assert.assertEquals(calculationResponse40.getCustomerId(), "99x-121212");

    }

    @Test
    public void testPenguinService60() throws Exception {
        Penguin penguin = new Penguin();
        penguin.setCustomerId("99x-121212");

        penguin.setNumberOfSingleUnits(60);
        CalculationResponse calculationResponse60 = penguinEarsService.calculatePenguinPrice(penguin);
        Assert.assertEquals(calculationResponse60.getTotalPrice(), 472.5, 0.0f);
        Assert.assertEquals(calculationResponse60.getCustomerId(), "99x-121212");

    }

    @Test
    public void testPenguinService65() throws Exception {
        Penguin penguin = new Penguin();
        penguin.setCustomerId("99x-121212");

        penguin.setNumberOfSingleUnits(65);
        CalculationResponse calculationResponse65 = penguinEarsService.calculatePenguinPrice(penguin);
        Assert.assertEquals(calculationResponse65.getTotalPrice(), 529.375, 0.0f);
        Assert.assertEquals(calculationResponse65.getCustomerId(), "99x-121212");

    }


}

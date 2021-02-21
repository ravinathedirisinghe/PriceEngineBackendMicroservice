import com.priceengine.dto.response.CalculationResponse;
import com.priceengine.entity.HorseShoe;
import com.priceengine.service.HorseShoeService;
import com.priceengine.service.HorseShoeServiceImpl;
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
public class HorseShoeServiceTest {

    @Configuration
    static class ContextConfiguration {

        @Bean
        public HorseShoeService horseShoeService() {
            HorseShoeService horseShoeService = new HorseShoeServiceImpl();
            return horseShoeService;
        }
    }

    @Autowired
    private HorseShoeService horseShoeService;

    @Test
    public void testHorseShoeService1() throws Exception {
        HorseShoe horseShoe = new HorseShoe();
        horseShoe.setCustomerId("99x-121212");

        horseShoe.setNumberOfSingleUnits(1);
        CalculationResponse calculationResponse1 = horseShoeService.calculateHorseShoePrice(horseShoe);
        Assert.assertEquals(calculationResponse1.getTotalPrice(), 214.5, 0.0f);
        Assert.assertEquals(calculationResponse1.getCustomerId(), "99x-121212");
    }

    @Test
    public void testHorseShoeService5() throws Exception {
        HorseShoe horseShoe = new HorseShoe();
        horseShoe.setCustomerId("99x-121212");
        horseShoe.setNumberOfSingleUnits(5);

        CalculationResponse calculationResponse5 = horseShoeService.calculateHorseShoePrice(horseShoe);
        Assert.assertEquals(calculationResponse5.getTotalPrice(), 825.0, 0.0f);
        Assert.assertEquals(calculationResponse5.getCustomerId(), "99x-121212");
    }

    @Test
    public void testHorseShoeService10() throws Exception {
        HorseShoe horseShoe = new HorseShoe();
        horseShoe.setCustomerId("99x-121212");
        horseShoe.setNumberOfSingleUnits(5);

        horseShoe.setNumberOfSingleUnits(10);
        CalculationResponse calculationResponse10 = horseShoeService.calculateHorseShoePrice(horseShoe);
        Assert.assertEquals(calculationResponse10.getTotalPrice(), 1650.0, 0.0f);
        Assert.assertEquals(calculationResponse10.getCustomerId(), "99x-121212");
    }

    @Test
    public void testHorseShoeService15() throws Exception {
        HorseShoe horseShoe = new HorseShoe();
        horseShoe.setCustomerId("99x-121212");
        horseShoe.setNumberOfSingleUnits(5);

        horseShoe.setNumberOfSingleUnits(15);
        CalculationResponse calculationResponse15 = horseShoeService.calculateHorseShoePrice(horseShoe);
        Assert.assertEquals(calculationResponse15.getTotalPrice(), 2227.5, 0.0f);
        Assert.assertEquals(calculationResponse15.getCustomerId(), "99x-121212");
    }

    @Test
    public void testHorseShoeService17() throws Exception {
        HorseShoe horseShoe = new HorseShoe();
        horseShoe.setCustomerId("99x-121212");
        horseShoe.setNumberOfSingleUnits(5);

        horseShoe.setNumberOfSingleUnits(17);
        CalculationResponse calculationResponse17 = horseShoeService.calculateHorseShoePrice(horseShoe);
        Assert.assertEquals(calculationResponse17.getTotalPrice(), 2656.5, 0.0f);
        Assert.assertEquals(calculationResponse17.getCustomerId(), "99x-121212");
    }

    @Test
    public void testHorseShoeService20() throws Exception {
        HorseShoe horseShoe = new HorseShoe();
        horseShoe.setCustomerId("99x-121212");
        horseShoe.setNumberOfSingleUnits(5);

        horseShoe.setNumberOfSingleUnits(20);
        CalculationResponse calculationResponse20 = horseShoeService.calculateHorseShoePrice(horseShoe);
        Assert.assertEquals(calculationResponse20.getTotalPrice(), 2970.0, 0.0f);
        Assert.assertEquals(calculationResponse20.getCustomerId(), "99x-121212");
    }


}

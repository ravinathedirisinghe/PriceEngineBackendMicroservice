import com.priceengine.dto.request.PriceRequestDto;
import com.priceengine.dto.response.CalculationResponse;
import com.priceengine.entity.HorseShoe;
import com.priceengine.entity.Penguin;
import com.priceengine.service.*;
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
public class PriceEngineServiceTest {

    @Configuration
    static class ContextConfiguration {


        @Bean
        public PenguinEarsService penguinEarsService() {
            PenguinEarsService penguinEarsService = new PenguinEarsServiceImpl();
            return penguinEarsService;
        }

        @Bean
        public HorseShoeService horseShoeService() {
            HorseShoeService horseShoeService = new HorseShoeServiceImpl();
            return horseShoeService;
        }

        @Bean
        public PriceEngineService priceEngineService() {
            PriceEngineService priceEngineService = new PriceEngineServiceImpl();
            return priceEngineService;
        }

    }

    @Autowired
    private PenguinEarsService penguinEarsService;

    @Autowired
    private HorseShoeService horseShoeService;

    @Autowired
    private PriceEngineService priceEngineService;


    @Test
    public void testPriceEngineSServiceHs() throws Exception {
        PriceRequestDto priceRequestDto = new PriceRequestDto();
        priceRequestDto.getPriceRequest().setCustomerId("99x-121212");

        HorseShoe horseShoe = new HorseShoe();
        horseShoe.setCustomerId("99x-121212");
        horseShoe.setNumberOfSingleUnits(17);

        CalculationResponse calculationResponseHs = horseShoeService.calculateHorseShoePrice(horseShoe);
        Assert.assertEquals(calculationResponseHs.getTotalPrice(), 2656.5, 0.0f);

    }

    @Test
    public void testPriceEngineSServicePn() throws Exception {
        PriceRequestDto priceRequestDto = new PriceRequestDto();
        priceRequestDto.getPriceRequest().setCustomerId("99x-121212");

        Penguin penguin = new Penguin();
        penguin.setCustomerId("99x-121212");
        penguin.setNumberOfSingleUnits(65);

        CalculationResponse calculationResponsePn = penguinEarsService.calculatePenguinPrice(penguin);
        Assert.assertEquals(calculationResponsePn.getTotalPrice(), 529.375, 0.0f);

    }

    @Test
    public void testPriceEngineSServicePnHsIntegrated() throws Exception {

        PriceRequestDto priceRequestDto = new PriceRequestDto();
        priceRequestDto.getPriceRequest().setCustomerId("99x-121212");

        Penguin penguin = new Penguin();
        penguin.setCustomerId("99x-121212");

        penguin.setNumberOfSingleUnits(65);
        CalculationResponse calculationResponsePn = penguinEarsService.calculatePenguinPrice(penguin);
        Assert.assertEquals(calculationResponsePn.getTotalPrice(), 529.375, 0.0f);

        HorseShoe horseShoe = new HorseShoe();
        horseShoe.setCustomerId("99x-121212");

        horseShoe.setNumberOfSingleUnits(17);
        CalculationResponse calculationResponseHs = horseShoeService.calculateHorseShoePrice(horseShoe);
        Assert.assertEquals(calculationResponseHs.getTotalPrice(), 2656.5, 0.0f);


        Assert.assertEquals(calculationResponsePn.getTotalPrice() + calculationResponseHs.getTotalPrice(), 3185.875, 0.0f);

    }

}

package com.priceengine.service;

import com.priceengine.dto.request.PriceRequestDto;
import com.priceengine.dto.response.CalculationResponse;
import com.priceengine.entity.HorseShoe;
import com.priceengine.entity.Penguin;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PriceEngineServiceImpl implements PriceEngineService {

    Logger logger = LoggerFactory.getLogger(PriceEngineServiceImpl.class);

    @Value("${product.name.horseshoe}")
    private String horseShoe;

    @Value("${product.name.penguin}")
    private String penguin;

    @Value("${product.name.horseshoe.carton.size}")
    private String horseShoeCartonSize;

    @Value("${product.name.penguin.carton.size}")
    private String penguinCartonSize;

    @Autowired
    HorseShoeService horseShoeService;

    @Autowired
    PenguinEarsService penguinEarsService;

    @SuppressWarnings("SuspiciousListRemoveInLoop")
    @Override
    public CalculationResponse calculateTotalPrice(PriceRequestDto priceRequestDto) throws Exception {

        String customerId = priceRequestDto.getCustomerId();
        CalculationResponse calculationResponse = null;
        int initialValue = 0;

        if (priceRequestDto.getCartItems().size() <= initialValue) {
            throw new Exception("cart item has empty values");
        }

        for (int i = 0; i < priceRequestDto.getCartItems().size(); i++) {
            if (penguin.equalsIgnoreCase(priceRequestDto.getCartItems().get(i).getProductName())) {

                Penguin penguin = new Penguin();
                int singleUnits = priceRequestDto.getCartItems().get(i).getNumberOfSingleUnits();

                penguin.setNumberOfSingleUnits(singleUnits);
                penguin.setCustomerId(customerId);

                double penguinTotalPrice = penguinEarsService.calculatePenguinPrice(penguin).getTotalPrice();

                //user can select both product in this case total price of both products will be calculated
                if (calculationResponse != null) {
                    double totalForBothProducts = calculationResponse.getTotalPrice() + penguinTotalPrice;
                    calculationResponse.setTotalPrice(totalForBothProducts);
                    calculationResponse.setCustomerId(priceRequestDto.getCustomerId());
                } else {
                    calculationResponse = new CalculationResponse();
                    calculationResponse.setTotalPrice(penguinTotalPrice);
                    calculationResponse.setCustomerId(priceRequestDto.getCustomerId());
                }
                logger.info("Penguin calculation response  : {} ", calculationResponse);
            }

            if (horseShoe.equalsIgnoreCase(priceRequestDto.getCartItems().get(i).getProductName())) {

                HorseShoe horseShoe = new HorseShoe();
                int singleUnits = priceRequestDto.getCartItems().get(i).getNumberOfSingleUnits();

                horseShoe.setNumberOfSingleUnits(singleUnits);
                horseShoe.setCustomerId(customerId);

                double horseShoeTotalPrice = horseShoeService.calculateHorseShoePrice(horseShoe).getTotalPrice();
                //user can select both product in this case total price of both products will be calculated
                if (calculationResponse != null) {
                    double totalForBothProducts = calculationResponse.getTotalPrice() + horseShoeTotalPrice;
                    calculationResponse.setTotalPrice(totalForBothProducts);
                    calculationResponse.setCustomerId(priceRequestDto.getCustomerId());
                } else {
                    calculationResponse = new CalculationResponse();
                    calculationResponse.setTotalPrice(horseShoeTotalPrice);
                    calculationResponse.setCustomerId(priceRequestDto.getCustomerId());
                }
                logger.info("Horse shoe calculation response  : {} ", calculationResponse);
            }
        }
        //TODO Save values to DB
        return calculationResponse;
    }


}

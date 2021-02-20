package com.priceengine.service;

import com.priceengine.dto.response.CalculationResponse;
import com.priceengine.entity.HorseShoe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HorseShoeServiceImpl implements HorseShoeService {

    Logger logger = LoggerFactory.getLogger(HorseShoeServiceImpl.class);

    @Override
    public CalculationResponse calculateHorseShoePrice(HorseShoe horseShoe) throws Exception{

        CalculationResponse calculationResponse = new CalculationResponse();
        //TODO save in the db with customer id
        String customerId = horseShoe.getCustomerId();
        double totalPrice = 0.0;
        double numberOfSingleUnits = (double) horseShoe.getNumberOfSingleUnits();

        if (numberOfSingleUnits > Constants.CARTON_SIZE_HORSE_SHOE) {
            double singleItems = numberOfSingleUnits % Constants.CARTON_SIZE_HORSE_SHOE;
            Double cartonNumber = (numberOfSingleUnits - singleItems) / Constants.CARTON_SIZE_HORSE_SHOE;

            if (cartonNumber >= Constants.DISCOUNT_ELIGIBILITY_COUNT) {
                totalPrice = cartonNumber * Constants.CARTON_PRICE_HORSE_SHOE * Constants.DISCOUNT_PERCENTAGE;
            } else {
                totalPrice = cartonNumber * Constants.CARTON_PRICE_HORSE_SHOE;
            }

            totalPrice += Constants.UNIT_PRICE_HORSE_SHOE * singleItems * Constants.ADDITIONAL_CHARGE_PERCENTAGE;

        }
        calculationResponse.setTotalPrice(totalPrice);
        calculationResponse.setCustomerId(customerId);

        return calculationResponse;

    }
}

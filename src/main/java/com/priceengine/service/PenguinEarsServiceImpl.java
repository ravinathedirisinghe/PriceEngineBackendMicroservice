package com.priceengine.service;

import com.priceengine.dto.response.CalculationResponse;
import com.priceengine.entity.Penguin;
import org.springframework.stereotype.Service;

@Service
public class PenguinEarsServiceImpl implements PenguinEarsService {

    @Override
    public CalculationResponse calculatePenguinPrice(Penguin penguin) throws Exception {

        CalculationResponse calculationResponse = new CalculationResponse();
        //TODO save in the db with customer id
        String customerId = penguin.getCustomerId();
        double totalPrice = 0.0;

        double numberOfSingleUnits = (double) penguin.getNumberOfSingleUnits();

        if (numberOfSingleUnits > Constants.CARTON_SIZE_PENGUIN) {
            Double singleItems = numberOfSingleUnits % Constants.CARTON_SIZE_PENGUIN;
            Double cartonNumber = (numberOfSingleUnits - singleItems) / Constants.CARTON_SIZE_PENGUIN;

            if (cartonNumber >= Constants.DISCOUNT_ELIGIBILITY_COUNT) {
                totalPrice = cartonNumber * Constants.CARTON_PRICE_PENGUIN * Constants.DISCOUNT_PERCENTAGE;
            } else {
                totalPrice = cartonNumber * Constants.CARTON_PRICE_PENGUIN;
            }

            totalPrice += Constants.UNIT_PRICE_PENGUIN * singleItems * Constants.ADDITIONAL_CHARGE_PERCENTAGE;

        }

        calculationResponse.setTotalPrice(totalPrice);
        calculationResponse.setCustomerId(customerId);

        return calculationResponse;
    }

}

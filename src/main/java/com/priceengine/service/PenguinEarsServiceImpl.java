package com.priceengine.service;

import com.priceengine.dto.response.CalculationResponse;
import com.priceengine.entity.Penguin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PenguinEarsServiceImpl implements PenguinEarsService {

    Logger logger = LoggerFactory.getLogger(PenguinEarsServiceImpl.class);

    @Override
    public CalculationResponse calculatePenguinPrice(Penguin penguin) throws Exception {

        CalculationResponse calculationResponse = new CalculationResponse();
        //TODO save in the db with customer id
        String customerId = penguin.getCustomerId();
        double totalPrice = 0.0;

        double numberOfSingleUnits = penguin.getNumberOfSingleUnits();

        if (numberOfSingleUnits % Constants.CARTON_SIZE_PENGUIN == 0 && numberOfSingleUnits / Constants.CARTON_SIZE_PENGUIN < Constants.DISCOUNT_ELIGIBILITY_COUNT) {
            totalPrice = Constants.CARTON_PRICE_PENGUIN * (numberOfSingleUnits / Constants.CARTON_SIZE_PENGUIN);

            calculationResponse.setTotalPrice(totalPrice);
            calculationResponse.setCustomerId(customerId);
            return calculationResponse;
        }

        if (numberOfSingleUnits > Constants.CARTON_SIZE_PENGUIN) {

            double singleItems = numberOfSingleUnits % Constants.CARTON_SIZE_PENGUIN;
            Double cartonNumber = (numberOfSingleUnits - singleItems) / Constants.CARTON_SIZE_PENGUIN;

            if (cartonNumber >= Constants.DISCOUNT_ELIGIBILITY_COUNT) {
                totalPrice = cartonNumber * Constants.CARTON_PRICE_PENGUIN * Constants.DISCOUNT_PERCENTAGE;
            } else {
                totalPrice = cartonNumber * Constants.CARTON_PRICE_PENGUIN;
            }

            totalPrice += Constants.UNIT_PRICE_PENGUIN * singleItems * Constants.ADDITIONAL_CHARGE_PERCENTAGE;

        } else {
            totalPrice += numberOfSingleUnits * Constants.UNIT_PRICE_PENGUIN * Constants.ADDITIONAL_CHARGE_PERCENTAGE;
        }

        calculationResponse.setTotalPrice(totalPrice);
        calculationResponse.setCustomerId(customerId);
        //TODO Save values to DB
        return calculationResponse;
    }

}

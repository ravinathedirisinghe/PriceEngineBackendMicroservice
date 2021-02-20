package com.priceengine.service;

import com.priceengine.dto.response.ItemResponse;
import com.priceengine.dto.response.ItemValues;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemViewServiceImpl implements ItemViewService {

    public ItemResponse generateItemResponse() throws Exception {

        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setDiscountEligibilityCount("Discounts are eligible for  " + Constants.DISCOUNT_ELIGIBILITY_COUNT + " or more cartons");
        itemResponse.setDiscountPercentage("Discount percentage is " + Constants.DISCOUNT_PERCENTAGE_ACTUAL + " % per cartons");
        itemResponse.setAdditionalCharge("Additional charge for unit items is " + Constants.ADDITIONAL_CHARGE_PERCENTAGE_ACTUAL + " % per unit for labor cost");

        ItemValues itemValuesHorseShoe = new ItemValues();
        itemValuesHorseShoe.setProductName(Constants.PRODUCT_NAME_HORSESHOE);
        itemValuesHorseShoe.setCartonSize(Constants.CARTON_SIZE_HORSE_SHOE);
        itemValuesHorseShoe.setCartonPrice(Constants.CARTON_PRICE_HORSE_SHOE);
        itemValuesHorseShoe.setUnitPrice(Constants.UNIT_PRICE_HORSE_SHOE);

        ItemValues itemValuesPenguin = new ItemValues();
        itemValuesPenguin.setProductName(Constants.PRODUCT_NAME_PENGUIN);
        itemValuesPenguin.setCartonSize(Constants.CARTON_SIZE_PENGUIN);
        itemValuesPenguin.setCartonPrice(Constants.CARTON_PRICE_PENGUIN);
        itemValuesPenguin.setUnitPrice(Constants.UNIT_PRICE_PENGUIN);

        List<ItemValues> itemValuesList = new ArrayList<>();
        itemValuesList.add(itemValuesHorseShoe);
        itemValuesList.add(itemValuesPenguin);

        itemResponse.setCartItems(itemValuesList);

        return itemResponse;
    }
}

package com.priceengine.service;

import com.priceengine.dto.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RateServiceImpl implements RateService {

    Logger logger = LoggerFactory.getLogger(RateServiceImpl.class);

    @Value("${product.name.horseshoe}")
    private String horseShoe;

    @Value("${product.name.penguin}")
    private String penguin;

    public PriceListResponse generatePriceListResponse() throws Exception {

        PriceListResponse priceListResponse = new PriceListResponse();

        PriceItems priceItemHorseShoe = new PriceItems();
        priceItemHorseShoe.setProductName(horseShoe);
        Prices pricesHorseShoe = new Prices();

        Map<Integer, Double> horseShoeValueMap = new HashMap<>();
        horseShoeValueMap.put(1, 214.5);
        horseShoeValueMap.put(2, 429.0);
        horseShoeValueMap.put(3, 643.5);
        horseShoeValueMap.put(4, 858.0);
        horseShoeValueMap.put(5, 825.0);
        horseShoeValueMap.put(6, 1039.5);
        horseShoeValueMap.put(7, 1254.0);
        horseShoeValueMap.put(8, 1468.5);
        horseShoeValueMap.put(9, 1683.0);
        horseShoeValueMap.put(10, 1650.0);
        horseShoeValueMap.put(15, 2227.5);
        horseShoeValueMap.put(20, 2970.0);

        pricesHorseShoe.setUnitPrices(sortByKey(horseShoeValueMap));
        priceItemHorseShoe.setPriceValue(pricesHorseShoe);

        PriceItems priceItemPenguin = new PriceItems();
        priceItemPenguin.setProductName(penguin);
        Prices pricesPenguin = new Prices();

        Map<Integer, Double> penguinValueMap = new HashMap<>();
        penguinValueMap.put(1, 11.375);
        penguinValueMap.put(2, 22.75);
        penguinValueMap.put(3, 34.125);
        penguinValueMap.put(4, 45.5);
        penguinValueMap.put(5, 56.875);
        penguinValueMap.put(20, 227.5);
        penguinValueMap.put(40, 350.0);
        penguinValueMap.put(60, 472.5);
        penguinValueMap.put(80, 630.0);

        pricesPenguin.setUnitPrices(sortByKey(penguinValueMap));
        priceItemPenguin.setPriceValue(pricesPenguin);


        List<PriceItems> priceItems = new ArrayList<>();
        priceItems.add(priceItemHorseShoe);
        priceItems.add(priceItemPenguin);

        priceListResponse.setPriceItems(priceItems);
        return priceListResponse;

    }

    public RateResponse generateRateResponse() throws Exception {

        RateResponse rateResponse = new RateResponse();
        rateResponse.setDiscountEligibilityCount("Discounts are eligible for  " + Constants.DISCOUNT_ELIGIBILITY_COUNT + " or more cartons");
        rateResponse.setDiscountPercentage("Discount percentage is " + Constants.DISCOUNT_PERCENTAGE_ACTUAL + " % per cartons");
        rateResponse.setAdditionalCharge("Additional charge for unit items is " + Constants.ADDITIONAL_CHARGE_PERCENTAGE_ACTUAL + " % per unit for labor cost");

        RateValues itemValuesHorseShoe = new RateValues();
        itemValuesHorseShoe.setProductName(Constants.PRODUCT_NAME_HORSESHOE);
        itemValuesHorseShoe.setCartonSize(Constants.CARTON_SIZE_HORSE_SHOE);
        itemValuesHorseShoe.setCartonPrice(Constants.CARTON_PRICE_HORSE_SHOE);
        itemValuesHorseShoe.setUnitPrice(Constants.UNIT_PRICE_HORSE_SHOE);

        RateValues itemValuesPenguin = new RateValues();
        itemValuesPenguin.setProductName(Constants.PRODUCT_NAME_PENGUIN);
        itemValuesPenguin.setCartonSize(Constants.CARTON_SIZE_PENGUIN);
        itemValuesPenguin.setCartonPrice(Constants.CARTON_PRICE_PENGUIN);
        itemValuesPenguin.setUnitPrice(Constants.UNIT_PRICE_PENGUIN);

        List<RateValues> itemValuesList = new ArrayList<>();
        itemValuesList.add(itemValuesHorseShoe);
        itemValuesList.add(itemValuesPenguin);

        rateResponse.setCartItems(itemValuesList);

        return rateResponse;
    }

    private static Map<Integer, Double> sortByKey(Map<Integer, Double> map) {
        List<Map.Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getKey));
        Map<Integer, Double> sortedMap = new LinkedHashMap<>();
        list.forEach(e -> sortedMap.put(e.getKey(), e.getValue()));
        return sortedMap;
    }

}

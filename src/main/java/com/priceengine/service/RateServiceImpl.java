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

        List<Item> itemHs = new ArrayList<>();

        //TODO Load values from DB
        Item it1Hs = new Item();
        it1Hs.setNumberOfUnits(1);
        it1Hs.setPriceValue(214.5);

        Item it2Hs = new Item();
        it2Hs.setNumberOfUnits(2);
        it2Hs.setPriceValue(429.0);

        itemHs.add(it1Hs);
        itemHs.add(it2Hs);

        PriceItems priceItemPenguin = new PriceItems();
        priceItemPenguin.setProductName(penguin);

        List<Item> itemPn = new ArrayList<>();
        //TODO Load values from DB
        Item it1Pn = new Item();
        it1Pn.setNumberOfUnits(1);
        it1Pn.setPriceValue(11.375);

        Item it2Pn = new Item();
        it2Pn.setNumberOfUnits(2);
        it2Pn.setPriceValue(22.75);

        itemPn.add(it1Pn);
        itemPn.add(it2Pn);

        //TODO Load values from DB

        priceItemHorseShoe.setItems(itemHs);
        priceItemPenguin.setItems(itemPn);

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

}

package com.priceengine.controller;

import com.priceengine.dto.error.CommonError;
import com.priceengine.dto.error.ErrorConstants;
import com.priceengine.dto.request.PriceRequestDto;
import com.priceengine.dto.response.CalculationResponse;
import com.priceengine.dto.response.PriceListResponse;
import com.priceengine.dto.response.RateResponse;
import com.priceengine.service.RateService;
import com.priceengine.service.PriceEngineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceEngineController {

    @Autowired
    private PriceEngineService priceEngineService;

    @Autowired
    private RateService rateService;

    Logger logger = LoggerFactory.getLogger(PriceEngineController.class);

    @PostMapping(value = "/calculate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> generateResponse(@Validated @RequestBody PriceRequestDto priceRequestDto) {
        try {
            CalculationResponse calculationResponse = priceEngineService.calculateTotalPrice(priceRequestDto);
            return new ResponseEntity<Object>(calculationResponse, HttpStatus.ACCEPTED.OK);
        } catch (Exception ex) {
            CommonError commonError = generateCommonError(ex);
            return new ResponseEntity<Object>(commonError, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/price-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPriceList() {
        try {
            PriceListResponse priceListResponse = rateService.generatePriceListResponse();
            return new ResponseEntity<Object>(priceListResponse, HttpStatus.ACCEPTED.OK);
        } catch (Exception ex) {
            CommonError commonError = generateCommonError(ex);
            return new ResponseEntity<Object>(commonError, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get-item-rates", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getItemRates() {
        try {
            RateResponse rateResponse = rateService.generateRateResponse();
            return new ResponseEntity<Object>(rateResponse, HttpStatus.ACCEPTED.OK);
        } catch (Exception ex) {
            CommonError commonError = generateCommonError(ex);
            return new ResponseEntity<Object>(commonError, HttpStatus.BAD_REQUEST);
        }
    }

    private CommonError generateCommonError(Exception ex) {
        CommonError commonError = new CommonError();
        commonError.setErrorCode(HttpStatus.BAD_REQUEST.toString());
        commonError.setErrorDesc(ex.getMessage());
        commonError.setCustomErrorMessage(ErrorConstants.CUSTOM_ERROR_MESSAGE);
        logger.error("Backend Error {}", commonError);
        return commonError;
    }

}

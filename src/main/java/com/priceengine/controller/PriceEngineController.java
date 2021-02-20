package com.priceengine.controller;

import com.priceengine.dto.request.PriceRequestDto;
import com.priceengine.dto.response.CalculationResponse;
import com.priceengine.dto.response.ItemResponse;
import com.priceengine.service.ItemViewService;
import com.priceengine.service.PriceEngineService;
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
    private ItemViewService itemViewService;

    @PostMapping(value = "/calculate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> generateResponse(@Validated @RequestBody PriceRequestDto priceRequestDto) {
        try {
            CalculationResponse calculationResponse = priceEngineService.calculateTotalPrice(priceRequestDto);
            return new ResponseEntity<Object>(calculationResponse, HttpStatus.ACCEPTED.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/getItemRates", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getItemRates() {
        try {
            ItemResponse itemResponse = itemViewService.generateItemResponse();
            return new ResponseEntity<Object>(itemResponse, HttpStatus.ACCEPTED.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

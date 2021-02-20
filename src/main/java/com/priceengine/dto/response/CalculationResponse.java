package com.priceengine.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculationResponse {

    private double totalPrice;

    private String customerId;

}

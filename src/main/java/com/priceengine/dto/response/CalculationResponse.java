package com.priceengine.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculationResponse {

    private double totalPrice;

    private String customerId;

    @Override
    public String toString() {
        return "CalculationResponse{" +
                "totalPrice=" + totalPrice +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}

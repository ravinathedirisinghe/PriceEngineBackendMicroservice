package com.priceengine.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RateResponse {

    private List<RateValues> cartItems;

    private String discountPercentage;

    private String additionalCharge;

    private String discountEligibilityCount;

    @Override
    public String toString() {
        return "ItemResponse{" +
                "cartItems=" + cartItems +
                '}';
    }

}

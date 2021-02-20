package com.priceengine.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceRequestDto {

    @JsonProperty("cartItems")
    private List<CartItems> cartItems;

    @JsonProperty("customerId")
    private String customerId;

    @Override
    public String toString() {
        return "PriceRequestDto{" +
                "cartItems=" + cartItems +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}

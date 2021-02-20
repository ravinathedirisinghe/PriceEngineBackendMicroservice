package com.priceengine.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartItems {

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("numberOfSingleUnits")
    private int numberOfSingleUnits;

    @Override
    public String toString() {
        return "CartItems{" +
                "productName='" + productName + '\'' +
                ", numberOfSingleUnits=" + numberOfSingleUnits +
                '}';
    }
}

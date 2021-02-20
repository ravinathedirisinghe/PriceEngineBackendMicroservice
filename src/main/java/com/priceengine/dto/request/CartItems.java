package com.priceengine.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartItems {

    @JsonProperty("productName")
    @NotNull(message = "product name cannot be empty")
    private String productName;

    @JsonProperty("numberOfSingleUnits")
    @NotNull(message = "number of purchased items cannot be empty")
    private int numberOfSingleUnits;

    @Override
    public String toString() {
        return "CartItems{" +
                "productName='" + productName + '\'' +
                ", numberOfSingleUnits=" + numberOfSingleUnits +
                '}';
    }
}

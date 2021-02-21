package com.priceengine.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceRequest {

    @JsonProperty("cartItems")
    @NotNull(message = "cart items cannot be empty")
    private List<CartItems> cartItems;

    @JsonProperty("customerId")
    @NotNull(message = "customer id cannot be empty")
    private String customerId;

    @Override
    public String toString() {
        return "PriceRequestDto{" +
                "cartItems=" + cartItems +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}

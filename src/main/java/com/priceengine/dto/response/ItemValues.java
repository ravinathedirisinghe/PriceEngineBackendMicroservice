package com.priceengine.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemValues {

    private String productName;

    private int cartonSize;

    private double cartonPrice;

    private double unitPrice;


}

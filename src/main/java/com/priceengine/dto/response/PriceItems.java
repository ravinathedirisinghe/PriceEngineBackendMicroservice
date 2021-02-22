package com.priceengine.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PriceItems {

    private String productName;

    private List<Item> items;

}

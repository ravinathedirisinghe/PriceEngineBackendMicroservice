package com.priceengine.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Prices {

    private Map<Integer, Double> unitPrices;

}

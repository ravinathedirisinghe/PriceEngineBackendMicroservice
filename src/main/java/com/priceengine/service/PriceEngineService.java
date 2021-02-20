package com.priceengine.service;

import com.priceengine.dto.request.PriceRequestDto;
import com.priceengine.dto.response.CalculationResponse;

public interface PriceEngineService {

    CalculationResponse calculateTotalPrice(PriceRequestDto priceRequestDto) throws Exception;

}

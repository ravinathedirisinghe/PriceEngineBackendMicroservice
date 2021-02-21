package com.priceengine.service;

import com.priceengine.dto.response.PriceListResponse;
import com.priceengine.dto.response.RateResponse;

public interface RateService {

    RateResponse generateRateResponse() throws Exception;

    PriceListResponse generatePriceListResponse() throws Exception;

}

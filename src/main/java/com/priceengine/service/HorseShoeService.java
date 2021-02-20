package com.priceengine.service;

import com.priceengine.dto.response.CalculationResponse;
import com.priceengine.entity.HorseShoe;

public interface HorseShoeService {

    CalculationResponse calculateHorseShoePrice(HorseShoe horseShoe) throws Exception;

}

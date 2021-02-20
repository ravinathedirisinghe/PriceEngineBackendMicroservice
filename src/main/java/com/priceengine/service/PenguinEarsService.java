package com.priceengine.service;

import com.priceengine.dto.response.CalculationResponse;
import com.priceengine.entity.Penguin;

public interface PenguinEarsService {

    CalculationResponse calculatePenguinPrice(Penguin penguin) throws Exception;

}

package com.priceengine.dto.response;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PriceListResponse {

    private List<PriceItems> priceItems;

}

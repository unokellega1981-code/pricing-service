package com.iopgrid.pricing_service.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Price {
    Long id;
    Long brandId;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Integer priceList;
    Long productId;
    Integer priority;
    BigDecimal price;
    String curr;
}

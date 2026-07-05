package com.iopgrid.pricing_service.service;

import com.iopgrid.pricing_service.dto.PriceDTO;

import java.time.LocalDateTime;

public interface PriceService {

    PriceDTO getApplicablePrice(
            LocalDateTime applicationDate,
            Long productId,
            Long brandId
    );
}

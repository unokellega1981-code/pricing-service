package com.iopgrid.pricing_service.service;

import com.iopgrid.pricing_service.dto.PriceDTO;
import com.iopgrid.pricing_service.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceDTO getApplicablePrice(
            LocalDateTime applicationDate,
            Long productId,
            Long brandId) {

        return null;
    }
}
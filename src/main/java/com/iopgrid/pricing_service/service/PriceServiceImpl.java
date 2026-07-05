package com.iopgrid.pricing_service.service;

import com.iopgrid.pricing_service.dto.PriceDTO;
import com.iopgrid.pricing_service.entity.PriceEntity;
import com.iopgrid.pricing_service.exception.PriceNotFoundException;
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
    public PriceDTO getApplicablePrice(LocalDateTime applicationDate, Long productId, Long brandId) {

        PriceEntity priceEntity = priceRepository
                .findApplicablePrices(
                        brandId,
                        productId,
                        applicationDate
                )
                .stream()
                .findFirst()
                .orElseThrow(() ->
                        new PriceNotFoundException(
                                "No price found for product "
                                        + productId +
                                        ", brand "
                                        + brandId +
                                        " and date "
                                        + applicationDate
                        )
                );

        return new PriceDTO(
                priceEntity.getProductId(),
                priceEntity.getBrandId(),
                priceEntity.getPriceList(),
                priceEntity.getStartDate(),
                priceEntity.getEndDate(),
                priceEntity.getPrice()
        );
    }
}

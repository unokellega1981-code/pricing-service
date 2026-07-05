package com.iopgrid.pricing_service.controller;

import com.iopgrid.pricing_service.dto.PriceDTO;
import com.iopgrid.pricing_service.service.PriceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<PriceDTO> getApplicablePrice(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime applicationDate,

            @RequestParam
            Long productId,

            @RequestParam
            Long brandId
    ) {

        PriceDTO priceDTO = priceService.getApplicablePrice(
                applicationDate,
                productId,
                brandId
        );

        return ResponseEntity.ok(priceDTO);
    }
}

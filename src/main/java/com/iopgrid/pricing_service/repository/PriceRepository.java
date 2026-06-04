package com.iopgrid.pricing_service.repository;

import com.iopgrid.pricing_service.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

}

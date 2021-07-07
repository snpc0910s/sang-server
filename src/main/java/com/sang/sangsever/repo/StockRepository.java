package com.sang.sangsever.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sang.sangsever.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

}

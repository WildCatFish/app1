package com.example.app1.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {
    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Long getData() {
        return stockRepository.count();
    }


    public Stock getOneEntity(StockPK pk){
        Optional<Stock> stock = stockRepository.findById(pk);

        return stock.get();
    }
}

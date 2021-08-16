package com.example.app1.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import  java.util.Optional;

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

    public List<Stock> getStockInRange(LocalDate fromDate, LocalDate toDate) {
        return stockRepository.searchByRange(fromDate, toDate);
    }

    public List<Stock> getTickerStockInRange(String ticker, LocalDate fromDate, LocalDate toDate){
        return stockRepository.searchByRangeAndTicker(ticker, fromDate, toDate);
    }

    public Double getMeanAdjCloseInRange(String ticker, LocalDate fromDate, LocalDate toDate) {
        return stockRepository.findMeanAdjcloseInRange(ticker, fromDate, toDate);
    }

    public List<Stock> getTopRecords(String ticker, int num){
        return stockRepository.showTopRecords(ticker, num);
    }

    public List<Stock> getTailRecords(String ticker, int num){
        return stockRepository.showTailRecords(ticker, num);
    }

    public List<Stock> getRecordsByTickerList(List<String> tickers){
        return stockRepository.searchByTickerList(tickers);
    }

    public List<OpenCloseView> getTickerClose(String ticker){
        return stockRepository.showTickerClose(ticker);
    }

}
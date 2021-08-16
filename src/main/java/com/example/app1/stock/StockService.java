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


    public List<Stock> getQuoteByDate(List<String> tickers, LocalDate fromDate, LocalDate toDate){
        return stockRepository.searchByDate(tickers, fromDate, toDate);
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


    public List<OpenCloseView> getTickerOpenClose(String ticker){
        return stockRepository.showTickerOpenClose(ticker);
    }
    public List<OpenCloseView> getTickerOpenCloseFromTo(String ticker, LocalDate fromDate, LocalDate toDate){
        return stockRepository.showTickerOpenCloseFromTo(ticker, fromDate, toDate);

    }
    public List<OpenCloseView> getTickerOpenCloseFrom(String ticker, LocalDate fromDate){
        return stockRepository.showTickerOpenCloseFrom(ticker, fromDate);

    }
    public List<OpenCloseView> getTickerOpenCloseTo(String ticker, LocalDate toDate){
        return stockRepository.showTickerOpenCloseTo(ticker, toDate);

    }

}
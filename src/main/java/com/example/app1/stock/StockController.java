package com.example.app1.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1.0/quote")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping(path = {"{tickers}/{fromDate}/{toDate}"})
    public List<Stock> getStockInRange( @PathVariable("tickers") List<String> tickers,
                                        @PathVariable("fromDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
                                        @PathVariable("toDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate) {
        return stockService.getQuoteByDate(tickers, fromDate, toDate);

    }

    @GetMapping(path = {"{tickers}"})
    public List<Stock> getStockInRange( @PathVariable("tickers") List<String> tickers) {

        return stockService.getQuoteByDate(tickers, LocalDate.parse("2019-12-31"), LocalDate.parse("2020-12-31"));
    }


    @GetMapping(path = "top/{ticker}/{num}")
    public List<Stock> getTopRecords(@PathVariable("ticker") String ticker, @PathVariable("num") int num){
        return stockService.getTopRecords(ticker, num);
    }

    @GetMapping(path = "tail/{ticker}/{num}")
    public List<Stock> getTailRecords(@PathVariable("ticker") String ticker, @PathVariable("num") int num){
        return stockService.getTailRecords(ticker, num);
    }

    @GetMapping(path= "tickers/{ticker_List}")
    public List<Stock> getByTickerList(@PathVariable("ticker_List") List<String> list){
        return stockService.getRecordsByTickerList(list);
    }

    @GetMapping(path="open_close_view/{ticker}")
    public List<OpenCloseView> getTickerClose(@PathVariable("ticker") String ticker){
        return stockService.getTickerClose(ticker);
    }

}
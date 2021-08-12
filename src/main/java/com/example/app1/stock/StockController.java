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
@RequestMapping(path="api/v1.0/stock")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }


    @GetMapping
    public Long getData() {
        return stockService.getData();
    }


    @GetMapping(path="{ticker}/{date}")
    public Stock getOne(@PathVariable("ticker") String ticker,
                        @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        StockPK stockPK = new StockPK(date, ticker);
        return stockService.getOneEntity(stockPK);
    }

    @GetMapping(path = {"range/{fromDate}/{toDate}", "{ticker}/range/{fromDate}/{toDate}"})
    public List<Stock> getStockInRange( @ PathVariable("ticker") Optional<String> ticker,
                                        @PathVariable("fromDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
                                        @PathVariable("toDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate)  {
        if(ticker.isPresent())
            return stockService.getTickerStockInRange(ticker.get(), fromDate, toDate);
        else
            return stockService.getStockInRange(fromDate, toDate);
    }

    @GetMapping(path = "AdjClose/{ticker}/range/{fromDate}/{toDate}")
    public Double getMeanAdjCloseInRange(@PathVariable("ticker") String ticker,
                                         @PathVariable("fromDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
                                         @PathVariable("toDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate) {
        return stockService.getMeanAdjCloseInRange(ticker, fromDate, toDate);
    }

    @GetMapping(path = "top/{num}")
    public List<Stock> getTopRecords(@PathVariable("num") int num){
        return stockService.getTopRecords(num);
    }

    @GetMapping(path = "tail/{num}")
    public List<Stock> getTailRecords(@PathVariable("num") int num){
        return stockService.getTailRecords(num);
    }

    @GetMapping(path= "tickers/{ticker_List}")
    public List<Stock> getByTickerList(@PathVariable("ticker_List") List<String> list){
        return stockService.getRecordsByTickerList(list);
    }

}

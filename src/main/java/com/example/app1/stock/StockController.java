package com.example.app1.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

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
                        @PathVariable("date") String date){
        LocalDate localDate = LocalDate.parse(date);
        StockPK stockPK = new StockPK(localDate, ticker);
        return stockService.getOneEntity(stockPK);
    }

    @GetMapping(path = "range/{fromDate}/{toDate}")
    public List<Stock> getStockInRange(@PathVariable("fromDate") String fromDate,
                                       @PathVariable("toDate") String toDate) {

        LocalDate fDate = LocalDate.parse(fromDate);
        LocalDate tDate = LocalDate.parse(toDate);
        return stockService.getStockInRange(fDate, tDate);
    }

    @GetMapping(path = "{ticker}/range/{fromDate}/{toDate}")
    public Double getMeanAdjcloseInRange(@PathVariable("ticker") String ticker,
                                              @PathVariable("fromDate") String fromDate,
                                              @PathVariable("toDate") String toDate) {

        LocalDate fDate = LocalDate.parse(fromDate);
        LocalDate tDate = LocalDate.parse(toDate);
        return stockService.getMeanAdjcloseInRange(ticker, fDate, tDate);
    }

}

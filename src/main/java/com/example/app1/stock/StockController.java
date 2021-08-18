package com.example.app1.stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;


@RestController
@Validated
@RequestMapping(path="api/v1.0/quote")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }


//    //Given the start date and end date inclusive as well as the ticker name, retrieve date for that particular ticker in that given time range
//    @GetMapping(path = {"{tickers}/{fromDate}/{toDate}"})
//    public List<Stock> getStockInRange( @PathVariable("tickers") List<String> tickers,
//                                        @PathVariable("fromDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
//                                        @PathVariable("toDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate) {
//        return stockService.getQuoteByDate(tickers, fromDate, toDate);
//
//    }


    @GetMapping(path = {"{tickers}"})
    public List<Stock> getStockInRange( @PathVariable("tickers") List<String> tickers) {

        return stockService.getQuoteByDate(tickers, LocalDate.parse("2019-12-31"), LocalDate.parse("2020-12-31"));
    }


    //sort the data in ascending order, retrieve the first specified number of records for that particular ticker
    @GetMapping(path = "top/{ticker}/{num}")
    public List<Stock> getTopRecords(@PathVariable("ticker") String ticker, @PathVariable("num") int num){
        return stockService.getTopRecords(ticker, num);
    }

    //sort the data in descending order, retrieve the first specified number of records for that particular ticker
    @GetMapping(path = "tail/{ticker}/{num}")
    public List<Stock> getTailRecords(@PathVariable("ticker") String ticker, @PathVariable("num") int num){
        return stockService.getTailRecords(ticker, num);
    }


    /*
    There are several valid formats for this path:
    *  1.if you just append the list of tickers' names without giving anything else, it will retrieve all the records
    * stored in the db for that particular list of tickers.
    *  2.a fromDate may also be added after the ticker list, for example, tickers/A,AAL?fromDate=2010-1-04, then it will retrieve all
    * the records stored in the db for that particular list of tickers from that day on.
    *  3.similarly, a toDate may also be added, for example, tickers/A,AAL?toDate=2010-1-04, then it will retrieve all the records
    * stored in the db for that particular list of tickers to that day.
    *  4. fromDate and toDate may be added at the same time, for example, tickers/A,AAL?fromDate=2020-12-05 & toDate=2020-12-31
    * */
    @GetMapping(path= "tickers/{ticker_List}")
    public List<Stock> getByTickerList(@PathVariable("ticker_List") List<String> tickers,
                                       @RequestParam(required = false)  String fromDate,
                                       @RequestParam(required = false)  String toDate){

        if(fromDate != null && toDate != null)
            return stockService.getRecordsByTickerListFromTo(tickers, fromDate, toDate);
        else if(fromDate != null)
            return stockService.getRecordsByTickerListFrom(tickers, fromDate);
        else if(toDate != null)
            return stockService.getRecordsByTickerListTo(tickers, toDate);
        else
            return stockService.getRecordsByTickerList(tickers);
    }

    //Similar as the one above
    @GetMapping(path="open_close_view/{ticker}")
    public List<OpenCloseView> getTickerOpenClose(@PathVariable("ticker") String ticker,
                                                  @RequestParam(required = false) String fromDate,
                                                  @RequestParam(required = false) String toDate) {
        if(fromDate != null && toDate != null)
            return stockService.getTickerOpenCloseFromTo(ticker, fromDate, toDate);
        else if(fromDate != null)
            return stockService.getTickerOpenCloseFrom(ticker, fromDate);
        else if(toDate != null)
            return stockService.getTickerOpenCloseTo(ticker, toDate);
        else
            return stockService.getTickerOpenClose(ticker);
    }

    //Similar as the one above
    @GetMapping(path="high_low_view/{ticker}")
    public List<HighLowView> getTickerHighLow(@PathVariable("ticker") String ticker,
                                                  @RequestParam(required = false) String fromDate,
                                                  @RequestParam(required = false) String toDate) {
        if(fromDate != null && toDate != null)
            return stockService.getTickerHighLowFromTo(ticker, fromDate, toDate);
        else if(fromDate != null)
            return stockService.getTickerHighLowFrom(ticker, fromDate);
        else if(toDate != null)
            return stockService.getTickerHighLowTo(ticker, toDate);
        else
            return stockService.getTickerHighLow(ticker);
    }

}
package com.example.app1.stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

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

    public List<Stock> getRecordsByTickerListFrom(List<String> tickers, String fromDate){
        LocalDate fDate;
        fDate = dateParser(fromDate);
        return stockRepository.searchByTickerListFrom(tickers, fDate);
    }

    public List<Stock> getRecordsByTickerListTo(List<String> tickers, String toDate) {
        LocalDate tDate;
        tDate = dateParser(toDate);
        return stockRepository.searchByTickerListTo(tickers, tDate);
    }

    public List<Stock> getRecordsByTickerListFromTo(List<String> tickers, String fromDate, String toDate){

        LocalDate fDate;
        fDate = dateParser(fromDate);
        LocalDate tDate;
        tDate = dateParser(toDate);
        return stockRepository.searchByTickerListFromTo(tickers, fDate, tDate);
    }



    public List<OpenCloseView> getTickerOpenClose(String ticker){
        return stockRepository.showTickerOpenClose(ticker);
    }

    public List<OpenCloseView> getTickerOpenCloseFromTo(String ticker, String fromDate, String toDate){
        LocalDate fDate;
        fDate = dateParser(fromDate);
        LocalDate tDate;
        tDate = dateParser(toDate);
        return stockRepository.showTickerOpenCloseFromTo(ticker, fDate, tDate);

    }
    public List<OpenCloseView> getTickerOpenCloseFrom(String ticker, String fromDate){
        LocalDate fDate;
        fDate = dateParser(fromDate);
        return stockRepository.showTickerOpenCloseFrom(ticker, fDate);

    }
    public List<OpenCloseView> getTickerOpenCloseTo(String ticker, String toDate){
        LocalDate tDate;
        tDate = dateParser(toDate);
        return stockRepository.showTickerOpenCloseTo(ticker, tDate);

    }

    public List<HighLowView>getTickerHighLow(String ticker){
        return stockRepository.showTickerHighLow(ticker);
    }

    public List<HighLowView>getTickerHighLowFromTo(String ticker, String fromDate, String toDate){
        LocalDate fDate;
        fDate = dateParser(fromDate);
        LocalDate tDate;
        tDate = dateParser(toDate);
        return stockRepository.showTickerHighLowFromTo(ticker, fDate, tDate);
    }

    public List<HighLowView>getTickerHighLowFrom(String ticker, String fromDate){
        LocalDate fDate;
        fDate = dateParser(fromDate);
        return stockRepository.showTickerHighLowFrom(ticker, fDate);
    }

    public List<HighLowView>getTickerHighLowTo(String ticker, String toDate){
        LocalDate tDate;
        tDate = dateParser(toDate);
        return stockRepository.showTickerHighLowTo(ticker, tDate);
    }




    private static LocalDate dateParser(String date){
        LocalDate Date;

        try{
            Date = LocalDate.parse(date);
        }
        catch(Exception e){
            throw new UnsupportedDateFormatException(date);
        }

        return Date;

    }


}
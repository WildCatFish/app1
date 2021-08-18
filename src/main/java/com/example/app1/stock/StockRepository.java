package com.example.app1.stock;

import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, StockPK> {

    @Query(value = "SELECT * FROM stock s WHERE s.ticker =?1 ORDER BY s.date DESC limit ?2", nativeQuery = true)
    List<Stock> showTailRecords(String ticker, int number);

    @Query(value = "SELECT * FROM stock s WHERE s.ticker=?1 ORDER BY s.date limit ?2", nativeQuery = true)
    List<Stock> showTopRecords(String ticker, int number);

    @Query(value = "SELECT * FROM stock s WHERE s.ticker IN ?1 AND s.date BETWEEN ?2 AND ?3 ORDER BY s.date", nativeQuery = true)
    List<Stock> searchByDate(List<String> ticker, LocalDate fromDate, LocalDate toDate);

    @Query(value = "SELECT * FROM stock s WHERE s.ticker in ?1", nativeQuery = true)
    List<Stock> searchByTickerList(List<String> tickers);

    @Query(value = "SELECT * FROM stock s WHERE s.ticker in ?1 AND s.date BETWEEN ?2 AND ?3 ORDER BY s.date", nativeQuery = true)
    List<Stock> searchByTickerListFromTo(List<String> tickers, LocalDate fromDate, LocalDate toDate);

    @Query(value = "SELECT * FROM stock s WHERE s.ticker in ?1 AND s.date >=?2 ORDER BY s.date", nativeQuery = true)
    List<Stock> searchByTickerListFrom(List<String> tickers, LocalDate fromDate);

    @Query(value = "SELECT * FROM stock s WHERE s.ticker in ?1 AND s.date <=?2", nativeQuery = true)
    List<Stock> searchByTickerListTo(List<String> tickers, LocalDate toDate);


    @Query(value = "SELECT (s.ticker) as ticker, (s.date) as date, (s.open) as open, (s.close) as close FROM stock s where s.ticker=?1", nativeQuery = true)
    List<OpenCloseView> showTickerOpenClose(String ticker);

    @Query(value = "SELECT (s.ticker) as ticker, (s.date) as date, (s.open) as open, (s.close) as close FROM stock s where s.ticker=?1 AND s.date BETWEEN ?2 AND ?3 ORDER BY s.date", nativeQuery = true)
    List<OpenCloseView> showTickerOpenCloseFromTo(String ticker, LocalDate fromDate, LocalDate toDate);

    @Query(value = "SELECT (s.ticker) as ticker, (s.date) as date, (s.open) as open, (s.close) as close FROM stock s where s.ticker=?1 AND s.date >=?2 ", nativeQuery = true)
    List<OpenCloseView> showTickerOpenCloseFrom(String ticker, LocalDate fromDate);

    @Query(value = "SELECT (s.ticker) as ticker, (s.date) as date, (s.open) as open, (s.close) as close FROM stock s where s.ticker=?1 AND s.date <=?2 ", nativeQuery = true)
    List<OpenCloseView> showTickerOpenCloseTo(String ticker, LocalDate toDate);


    @Query(value = "SELECT (s.ticker) as ticker, (s.date) as date, (s.high) as high, (s.low) as low FROM stock s where s.ticker=?1", nativeQuery = true)
    List<HighLowView> showTickerHighLow(String ticker);

    @Query(value = "SELECT (s.ticker) as ticker, (s.date) as date, (s.high) as high, (s.low) as low FROM stock s where s.ticker=?1 AND s.date BETWEEN ?2 AND ?3 ORDER BY s.date", nativeQuery = true)
    List<HighLowView> showTickerHighLowFromTo(String ticker, LocalDate fromDate, LocalDate toDate);

    @Query(value = "SELECT (s.ticker) as ticker, (s.date) as date, (s.high) as high, (s.low) as low FROM stock s where s.ticker=?1 AND s.date >=?2 ", nativeQuery = true)
    List<HighLowView> showTickerHighLowFrom(String ticker, LocalDate fromDate);

    @Query(value = "SELECT (s.ticker) as ticker, (s.date) as date, (s.high) as high, (s.low) as low FROM stock s where s.ticker=?1 AND s.date <=?2 ", nativeQuery = true)
    List<HighLowView> showTickerHighLowTo(String ticker, LocalDate toDate);



}

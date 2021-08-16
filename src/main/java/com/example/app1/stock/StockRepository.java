package com.example.app1.stock;

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

    @Query(value = "SELECT * FROM stock s WHERE s.date BETWEEN ?1 AND ?2 ORDER BY s.date", nativeQuery = true)
    List<Stock> searchByRange(LocalDate fromDate, LocalDate toDate);

    @Query(value = "SELECT * FROM stock s WHERE s.ticker=?1 AND s.date BETWEEN ?2 AND ?3 ORDER BY s.date", nativeQuery = true)
    List<Stock> searchByRangeAndTicker(String ticker, LocalDate fromDate, LocalDate toDate);

    @Query(value = "SELECT AVG(s.adjclose) FROM stock s WHERE s.ticker = ?1 AND s.date BETWEEN ?2 AND ?3 ORDER BY s.date", nativeQuery = true)
    Double findMeanAdjcloseInRange(String ticker, LocalDate fromDate, LocalDate toDate);

    @Query(value = "SELECT * FROM stock s WHERE s.ticker in ?1", nativeQuery = true)
    List<Stock> searchByTickerList(List<String> tickers);

    @Query(value = "SELECT (s.ticker) as ticker, (s.date) as date, (s.open) as open, (s.close) as close FROM stock s where s.ticker=?1", nativeQuery = true)
    List<OpenCloseView> showTickerClose(String ticker);


}

package com.example.app1.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, StockPK> {

    @Query(value = "SELECT * FROM stock s WHERE s.date BETWEEN ?1 AND ?2 ORDER BY s.date", nativeQuery = true)
    List<Stock> findByCreateTimestampBetween(LocalDate fromDate, LocalDate toDate);
}

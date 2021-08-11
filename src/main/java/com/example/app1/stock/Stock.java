package com.example.app1.stock;

import javax.persistence.*;


@Entity
@Table
public class Stock {

    @EmbeddedId
    private StockPK id;

    @Column(nullable = false)
    private Double open;

    @Column(nullable = false)
    private Double high;

    @Column(nullable = false)
    private Double low;

    @Column(nullable = false)
    private Double close;

    @Column(nullable = false)
    private Double adjclose;

    @Column(nullable = false)
    private Integer volume;



    public Stock() {
    }

    public Stock(StockPK id, Double open, Double high, Double low, Double close, Double adjclose, Integer volume) {
        this.id = id;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.adjclose = adjclose;
        this.volume = volume;
    }
}

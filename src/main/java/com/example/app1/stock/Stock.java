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

    public StockPK getId() {
        return id;
    }

    public void setId(StockPK id) {
        this.id = id;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Double getAdjclose() {
        return adjclose;
    }

    public void setAdjclose(Double adjclose) {
        this.adjclose = adjclose;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }



    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", adjclose=" + adjclose +
                ", volume=" + volume +
                '}';
    }
}

package com.example.app1.stock;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class StockPK implements Serializable {

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String ticker;

    public LocalDate getDate() {
        return date;
    }

    public String getTicker() {
        return ticker;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.date == null) ? 0 : this.date.hashCode());
        result = prime * result
                + ((this.ticker == null) ? 0 : this.ticker.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StockPK other = (StockPK) obj;
        if (this.date == null) {
            if (other.date != null)
                return false;
        } else if (!this.date.equals(other.date))
            return false;
        if (this.ticker == null) {
            return other.ticker == null;
        } else return this.ticker.equals(other.ticker);
    }

}

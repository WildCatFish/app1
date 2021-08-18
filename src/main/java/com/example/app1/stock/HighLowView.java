package com.example.app1.stock;

import java.time.LocalDate;

public interface HighLowView {

    String getTicker();
    LocalDate getDate();
    Double getHigh();
    Double getLow();
}

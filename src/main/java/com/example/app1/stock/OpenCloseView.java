package com.example.app1.stock;

import java.time.LocalDate;

public interface OpenCloseView {

    String getTicker();
    LocalDate getDate();
    Double getClose();
    Double getOpen();

}

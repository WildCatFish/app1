package com.example.app1.stock;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedDateFormatException extends IllegalArgumentException{

    String content;

    public UnsupportedDateFormatException(String content){
        super("Date format " + content + " is not supported, date must be in the format of yyyy-MM-dd");
        this.content = content;
    }
}

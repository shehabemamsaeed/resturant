package com.resurant.resturant.dto;

import java.time.LocalDateTime;

public class StringModel {
    LocalDateTime localDateTime;
    String message;

    public StringModel(String message) {
        this.message = message;
        localDateTime = LocalDateTime.now();
    }

}

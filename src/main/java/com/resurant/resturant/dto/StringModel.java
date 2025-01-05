package com.resurant.resturant.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
@NoArgsConstructor
public class StringModel {
    LocalDateTime localDateTime;
    String message;

    public StringModel(String message) {
        this.message = message;
        localDateTime = LocalDateTime.now();
    }

}

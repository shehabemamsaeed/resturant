package com.resurant.resturant.utils;

import java.util.UUID;

public class ExtractCode {
    public static String getCode(){
       return UUID.randomUUID().toString();
    }
}

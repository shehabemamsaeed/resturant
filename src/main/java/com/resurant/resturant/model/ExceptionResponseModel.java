package com.resurant.resturant.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Setter
@Getter

public class ExceptionResponseModel {
@JsonProperty("Http status")
private HttpStatus httpStatus;
@JsonProperty("Data and Time")
private LocalDateTime localDateTime;
@JsonProperty("Error Message")
private BundleMessageModel bundleMessageModel;

public ExceptionResponseModel(HttpStatus httpStatus, BundleMessageModel bundleMessageModel){
    this.httpStatus = httpStatus;
    localDateTime =LocalDateTime.now();
    this.bundleMessageModel  =bundleMessageModel;
}

}

package com.resurant.resturant.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class BundleMessageModel {

@JsonProperty("message arabic")
private String messageAr;
    @JsonProperty("message english")
private String messageEn;

    public BundleMessageModel(String messageAr, String messageEn) {
        this.messageAr = messageAr;
        this.messageEn = messageEn;
    }
}

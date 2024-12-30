package com.resurant.resturant.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChefsDto {
    private Long id;

    public ChefsDto(Long id, String name, String logoPath, String faceLink, String tweLink, String instaLink) {
        this.id = id;
        this.name = name;
        this.logoPath = logoPath;
        this.faceLink = faceLink;
        this.tweLink = tweLink;
        this.instaLink = instaLink;
    }

    private  String name;

    public ChefsDto() {
    }
@JsonProperty("logo_path")
    private String logoPath;
    private String faceLink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getFaceLink() {
        return faceLink;
    }

    public void setFaceLink(String faceLink) {
        this.faceLink = faceLink;
    }

    public String getTweLink() {
        return tweLink;
    }

    public void setTweLink(String tweLink) {
        this.tweLink = tweLink;
    }

    public String getInstaLink() {
        return instaLink;
    }

    public void setInstaLink(String instaLink) {
        this.instaLink = instaLink;
    }

    private String tweLink;
    private String instaLink;

}


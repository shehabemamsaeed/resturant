package com.resurant.resturant.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.resurant.resturant.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductDto {
    private Long id;
    private String name;
    private String describtion;
    @JsonProperty("LOGO_PATH")
    private String logoPath;
    private String price;
    @JsonIgnore
    private Category category;
}

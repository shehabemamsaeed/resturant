package com.resurant.resturant.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.resurant.resturant.model.Product;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    @JsonProperty("LOGO_PATH")
    private String logoPath;
    private String flag;
    private List<Product> productDtoList;

}

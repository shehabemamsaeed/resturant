package com.resurant.resturant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestOrderDto {
    private Long id;
    private String code;
    private String totalPrice;
    private String totalQuantity;
    private List<Long> productId;

}

package com.resurant.resturant.dto;

import com.resurant.resturant.model.Client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    private Long id;
    private String name;
    private String email;
    private String subject;
    private String message;
}

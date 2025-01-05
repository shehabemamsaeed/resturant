package com.resurant.resturant.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.resurant.resturant.model.PhotoFile;
import com.resurant.resturant.model.RequestOrder;
import com.resurant.resturant.model.Roles;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private Long id;
    private String name;
    private String password;
    private String email;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonIgnore
    private Set<RequestOrder> requestOrders;
    @JsonIgnore
    private Set<Roles> roles;
    @JsonProperty("photo_file")
    private MultipartFile photoFile;
}

package com.resurant.resturant.mapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.resurant.resturant.dto.RequestOrderDto;
import com.resurant.resturant.model.RequestOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RequestOrderMapper {
    RequestOrderMapper mapper = Mappers.getMapper(RequestOrderMapper.class);
    @Mapping(source = "code",target ="code")
    RequestOrder convertRequestOrderDtoToRequestOrder(RequestOrderDto requestOrderDto);
}

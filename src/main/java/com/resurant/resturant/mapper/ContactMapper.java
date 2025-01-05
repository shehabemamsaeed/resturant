package com.resurant.resturant.mapper;

import com.resurant.resturant.dto.ContactDto;
import com.resurant.resturant.model.ContactInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ContactMapper {

        ContactMapper mapper = Mappers.getMapper(ContactMapper.class);
        @Mapping(source ="name" ,target ="name" )
        ContactInfo convertToContact(ContactDto contactDto);


}

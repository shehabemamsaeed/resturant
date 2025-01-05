package com.resurant.resturant.mapper;

import com.resurant.resturant.dto.ClientDto;
import com.resurant.resturant.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.*;

@Mapper
public interface ClientMapper {
    ClientMapper mapper = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "phoneNumber", target = "phoneNumber")
    Client clientDtoToClient(ClientDto clientDto);

    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(target = "photoFile", ignore = true)
    ClientDto clientToDto(Client client);

    @Mapping(source = "phoneNumber", target = "phoneNumber")
    List<ClientDto> clientsToClintsDto(List<Client> client);

    @Mapping(source = "phoneNumber", target = "phoneNumber")
    List<Client> clientsDtoToClients(List<ClientDto> clientDto);

}

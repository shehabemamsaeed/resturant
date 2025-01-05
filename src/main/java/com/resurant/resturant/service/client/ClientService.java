package com.resurant.resturant.service.client;

import com.resurant.resturant.dto.ClientDto;
import com.resurant.resturant.dto.TokenDto;
import com.resurant.resturant.model.Client;

import java.io.IOException;
import java.util.*;

public interface ClientService {
      TokenDto loginService(ClientDto clientDto) throws Exception;

    TokenDto signUpService(ClientDto clientDto) throws IOException;
    ClientDto getClientWithName(String name);

    List<ClientDto> getAllClients();
    ClientDto checkClientWithToken(String token);

    Client getClientById(Long id);
}

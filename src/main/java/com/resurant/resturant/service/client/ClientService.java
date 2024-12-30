package com.resurant.resturant.service.client;

import com.resurant.resturant.dto.ClientDto;
import com.resurant.resturant.dto.TokenDto;
import java.util.*;

public interface ClientService {
      TokenDto loginService(ClientDto clientDto) throws Exception;

    TokenDto signUpService(ClientDto clientDto);
    ClientDto getClientWithName(String name);

    List<ClientDto> getAllClients();
    ClientDto checkClientWithToken(String token);
}

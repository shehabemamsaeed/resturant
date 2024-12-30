package com.resurant.resturant.service.client.impl;

import com.resurant.resturant.config.jwt.TokenHandler;
import com.resurant.resturant.dto.ClientDto;
import com.resurant.resturant.dto.TokenDto;
import com.resurant.resturant.mapper.ClientMapper;
import com.resurant.resturant.model.Client;
import com.resurant.resturant.repo.ClientRepo;
import com.resurant.resturant.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private TokenHandler tokenHandler;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public TokenDto loginService(ClientDto clientDto) throws Exception {

        ClientDto clientDto1 = getClientWithName(clientDto.getName());
        boolean isPass = passwordEncoder.matches(clientDto.getPassword(),clientDto1.getPassword());
        if(isPass){
          String token = tokenHandler.createToken(clientDto);
        return new TokenDto(token,LocalDateTime.now(),"Success Login");
        } else if (!isPass) {
            throw new RuntimeException("error.wrong.password");
        } else{
            return new TokenDto("Failed to create key",LocalDateTime.now(),"Failed Login");
        }

    }

    @Override
    public TokenDto signUpService(ClientDto clientDto) {

            List<ClientDto> clientDtos = getAllClients();
            for(ClientDto clientDto1:clientDtos){
                if(clientDto1.getName().equals(clientDto.getName())){
                  throw new RuntimeException("error.same.name");
                }
            }

            Client client = ClientMapper.mapper.clientDtoToClient(clientDto);
            String hashedPass = passwordEncoder.encode(client.getPassword());

            client.setPassword(hashedPass);
           clientRepo.save(client);
            String token = tokenHandler.createToken(clientDto);
            return  new TokenDto(token, LocalDateTime.now(),"Created Account");

    }

    @Override
    public ClientDto getClientWithName(String name) {
        try{
        Client client = clientRepo.findByName(name);
        ClientDto clientDto =ClientMapper.mapper.clientToDto(client);
        if(clientDto==null){
            throw new RuntimeException("error.data");
        }
            return clientDto;
    }catch (RuntimeException e){
            throw  new RuntimeException("error.catch");
        }
    }


    @Override
    public List<ClientDto> getAllClients() {
        List<Client> client = clientRepo.findAll();
        List<ClientDto> clientDtos = ClientMapper.mapper.clientsToClintsDto(client);
        if(clientDtos.isEmpty()){
            throw  new RuntimeException("error.data");
        }else{
            return clientDtos;
        }
    }

    @Override
    public ClientDto checkClientWithToken(String token) {
     String  name  = tokenHandler.getName(token);
        ClientDto clientDto = getClientWithName(name);
        if(clientDto==null){
            throw new RuntimeException("error.data");
        }
        return clientDto;
    }
}

package com.resurant.resturant.controller.client;

import com.resurant.resturant.dto.ClientDto;
import com.resurant.resturant.dto.TokenDto;
import com.resurant.resturant.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.net.URI;

@RestController
@RequestMapping("/client")
public class ClientController {

@Autowired
private ClientService clientService;
    @PostMapping("/sign_up")
    public ResponseEntity<TokenDto> signUp(@Validated @ModelAttribute  ClientDto clientDto) throws IOException {
      TokenDto tokenDto  =clientService.signUpService(clientDto);
        return ResponseEntity.created(URI.create("/client/sign_up")).body(tokenDto);
    }
    @GetMapping("/login")
    public ResponseEntity<TokenDto> login(@Validated @RequestBody ClientDto clientDto) throws Exception {
 TokenDto tokenDto =  clientService.loginService(clientDto);
    return ResponseEntity.ok(tokenDto);
    }

    @GetMapping("get_all_clients")
    public ResponseEntity<List<ClientDto>> getAllClient(){
        return ResponseEntity.ok(clientService.getAllClients());
    }

}

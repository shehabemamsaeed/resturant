package com.resurant.resturant.service.contactInfo;

import com.resurant.resturant.dto.ClientDto;
import com.resurant.resturant.dto.ContactDto;
import com.resurant.resturant.mapper.ClientMapper;
import com.resurant.resturant.mapper.ContactMapper;
import com.resurant.resturant.model.Client;
import com.resurant.resturant.model.ContactInfo;
import com.resurant.resturant.repo.ContactRepo;
import com.resurant.resturant.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactInfoService{

    @Autowired
    private ContactRepo contactRepo;
    @Autowired
    private ClientService clientService;
    @Override
    public String sendMessage(ContactDto contactDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ClientDto clientDto = (ClientDto) authentication.getPrincipal();
        Client client =    clientService.getClientById(clientDto.getId());
        if(client ==null){
        throw  new RuntimeException("error.data");
        }
      ContactInfo contactInfo =  ContactMapper.mapper.convertToContact(contactDto);
        contactInfo.setClient(client);
     if(contactInfo == null){
         throw new RuntimeException("error.data");
     }
     contactRepo.save(contactInfo);
     return "success sent message";
    }
}

package com.resurant.resturant.controller.contactInfo;

import com.resurant.resturant.dto.ContactDto;
import com.resurant.resturant.model.ContactInfo;
import com.resurant.resturant.service.contactInfo.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/contact_us")
public class ContactInfoController {
   @Autowired
    ContactInfoService contactInfoService;
    @PostMapping("/send_message")
    public ResponseEntity<String> sendMessage(@RequestBody ContactDto contactInfo){
        String message= contactInfoService.sendMessage(contactInfo);
        return ResponseEntity.created(URI.create("/contact_us/send_message")).body(message);
    }
}

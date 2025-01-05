package com.resurant.resturant.service.contactInfo;

import com.resurant.resturant.dto.ContactDto;

public interface ContactInfoService {
    String sendMessage(ContactDto contactDto);
}

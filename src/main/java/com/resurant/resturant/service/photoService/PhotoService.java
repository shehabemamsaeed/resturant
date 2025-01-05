package com.resurant.resturant.service.photoService;

import com.resurant.resturant.model.Client;
import com.resurant.resturant.model.PhotoFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {
    PhotoFile uploadPhoto(MultipartFile photoFileDto) throws IOException;

}

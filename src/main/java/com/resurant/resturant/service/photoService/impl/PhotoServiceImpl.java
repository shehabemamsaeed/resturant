package com.resurant.resturant.service.photoService.impl;

import com.resurant.resturant.model.Client;
import com.resurant.resturant.model.PhotoFile;
import com.resurant.resturant.repo.PhotoRepo;
import com.resurant.resturant.service.photoService.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoRepo photoRepo;

    @Override
    public PhotoFile uploadPhoto(MultipartFile photoFileDto) throws IOException {
        PhotoFile photoFile = new PhotoFile();
        photoFile.setFileName(photoFileDto.getOriginalFilename());
        photoFile.setFileType(photoFileDto.getContentType());
        photoFile.setFileSize(photoFileDto.getSize());
        photoFile.setData(photoFileDto.getBytes());
        if(photoFile==null){
            throw new IOException("error.data");
        }


        return photoFile;
    }
}

package com.resurant.resturant.service.chefs.impl;


import com.resurant.resturant.dto.ChefsDto;
import com.resurant.resturant.model.Chefs;
import com.resurant.resturant.repo.ChefsRepo;
import com.resurant.resturant.service.chefs.ChefsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChefsServiceImpl implements ChefsService {
    @Autowired
    private ChefsRepo chefsRepo;

    @Override
    public List<ChefsDto> getAllChefsService() {
        try{
            List<Chefs> chefs = chefsRepo.findAll();
            List<ChefsDto> chefsDtoList =new ArrayList<>();
            for(Chefs chefs1:chefs){
                ChefsDto chefsDto = new ChefsDto(chefs1.getId(),chefs1.getName(),chefs1.getLogoPath(),chefs1.getFaceLink(),chefs1.getTweLink(),chefs1.getInstaLink());
            chefsDtoList.add(chefsDto);
            }
            if(chefsDtoList == null ||chefsDtoList.isEmpty()){
                throw new RuntimeException("error.data");
            }
            return chefsDtoList;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}

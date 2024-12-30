package com.resurant.resturant.service.category.impl;


import com.resurant.resturant.dto.CategoryDto;
import com.resurant.resturant.dto.StringModel;
import com.resurant.resturant.mapper.CategoryMapper;
import com.resurant.resturant.model.Category;
import com.resurant.resturant.repo.CategoryRepo;
import com.resurant.resturant.service.category.CategoryService;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public List<CategoryDto> getAllCategory() throws Exception {
        try{
            List<Category> categoryList = categoryRepo.findAll();

                    List<CategoryDto> categoryDtos= CategoryMapper.mapper.convertCategoryToDto(categoryList);


            if(categoryDtos.isEmpty()){
                throw new RuntimeException("error.data");
            }
            return  categoryDtos;
        }catch (Exception e){
         throw new Exception("error.data"+e);
        }
    }

    @Override
    public CategoryDto getCategoryById(Long id) throws Exception {
        try{
              Category category = categoryRepo.getReferenceById(id);
          //  CategoryDto categoryDto= CategoryMapper.mapper.map(category);

            CategoryDto categoryDto1 = CategoryMapper.mapper.map(category);
            return categoryDto1;
        }catch (Exception e){
            throw new SystemException("error.data");
        }
    }

    @Override
    public StringModel createCategory(CategoryDto categoryDto) throws Exception {
        try{
            Category category= new Category(categoryDto.getId(),categoryDto.getName(),
                    categoryDto.getLogoPath(),categoryDto.getFlag(),categoryDto.getProductDtoList());
        Category category1 =  categoryRepo.save(category);
          if(category1!=null){
              return new StringModel("Created Category");
          }else{
              throw  new Exception("Don\'t created category ");
          }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

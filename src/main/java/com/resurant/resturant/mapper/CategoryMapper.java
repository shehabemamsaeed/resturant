package com.resurant.resturant.mapper;


import com.resurant.resturant.dto.CategoryDto;
import com.resurant.resturant.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper mapper = Mappers.getMapper(CategoryMapper.class);

    CategoryDto map(Category category);

    List<CategoryDto> convertCategoryToDto(List<Category> categoryList);



}

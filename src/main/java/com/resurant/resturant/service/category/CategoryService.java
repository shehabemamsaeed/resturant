package com.resurant.resturant.service.category;



import com.resurant.resturant.dto.CategoryDto;
import com.resurant.resturant.dto.StringModel;

import java.util.List;
public interface CategoryService {
    List<CategoryDto> getAllCategory() throws Exception;

    CategoryDto getCategoryById(Long id) throws Exception;

    StringModel createCategory(CategoryDto categoryDto) throws Exception;
}

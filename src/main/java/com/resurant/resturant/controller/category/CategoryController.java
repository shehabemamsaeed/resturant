package com.resurant.resturant.controller.category;


import com.resurant.resturant.dto.CategoryDto;
import com.resurant.resturant.dto.StringModel;
import com.resurant.resturant.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

@GetMapping("/all_category")
    public ResponseEntity<List<CategoryDto>> getAllCategoryC()throws Exception{
    return ResponseEntity.ok(categoryService.getAllCategory());
}
@PostMapping("/create_category")
    public ResponseEntity<StringModel> createCategoryC(@RequestBody CategoryDto categoryDto) throws Exception{
    StringModel stringModel = categoryService.createCategory(categoryDto);
    return ResponseEntity.created(URI.create("/category/save_category")).body(stringModel);
}





}

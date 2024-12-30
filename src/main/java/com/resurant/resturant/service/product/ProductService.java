package com.resurant.resturant.service.product;



import com.resurant.resturant.dto.ProductDto;
import com.resurant.resturant.dto.StringModel;

import java.util.List;
public interface ProductService {
    List<ProductDto> getAllProductsByCategoryId(Long id)throws Exception;

    StringModel createProductService(ProductDto productDto) throws Exception;

    List<ProductDto> getAllProductsByLetters(String letters);
}

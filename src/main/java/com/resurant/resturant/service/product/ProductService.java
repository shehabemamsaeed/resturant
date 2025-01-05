package com.resurant.resturant.service.product;



import com.resurant.resturant.dto.ProductDto;
import com.resurant.resturant.dto.StringModel;
import com.resurant.resturant.model.Product;

import java.util.List;
public interface ProductService {
    List<ProductDto> getAllProductsByCategoryId(Long id)throws Exception;

    StringModel createProductService(ProductDto productDto) throws Exception;

    List<ProductDto> getAllProductsByLetters(String letters);

    List<ProductDto> getAllProducts(int pageNumber,int pageSize);

    ProductDto getProductsByName(String name);

    List<Product> getProductsByIds(List<Long> id);

    Integer getProductSizeS();

    Integer getProductSizeByIdS(Long id);
}

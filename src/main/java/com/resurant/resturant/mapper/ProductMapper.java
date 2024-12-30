package com.resurant.resturant.mapper;


import com.resurant.resturant.dto.ProductDto;
import com.resurant.resturant.model.Product;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface ProductMapper {

    ProductMapper categoryMapper = Mappers.getMapper(ProductMapper.class);
    ProductDto map(Product product);
    Product productDtoToProduct(ProductDto productDto);

    List<ProductDto> convertProductToDto(List<Product> productList);
}

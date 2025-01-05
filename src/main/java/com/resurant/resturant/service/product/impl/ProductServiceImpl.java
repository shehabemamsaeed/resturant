package com.resurant.resturant.service.product.impl;


import com.resurant.resturant.dto.CategoryDto;
import com.resurant.resturant.dto.ProductDto;
import com.resurant.resturant.dto.StringModel;
import com.resurant.resturant.mapper.ProductMapper;
import com.resurant.resturant.model.Product;
import com.resurant.resturant.repo.ProductRepo;
import com.resurant.resturant.service.category.CategoryService;
import com.resurant.resturant.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
   @Autowired
   private ProductRepo productRepo;
   @Autowired
   private CategoryService categoryService;

    @Override
    public List<ProductDto> getAllProductsByCategoryId(Long id)throws Exception {
        try{
            CategoryDto categoryDto=categoryService.getCategoryById(id);
            List<Product> products = productRepo.findByCategory_Id(categoryDto.getId());
            List<ProductDto> productDtoList = ProductMapper.categoryMapper.convertProductToDto(products);
            if(productDtoList.isEmpty()){
                throw new RuntimeException("error.data");
            }
            return productDtoList;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public StringModel createProductService(ProductDto productDto) throws Exception {
        try {
            Product product = ProductMapper.categoryMapper.productDtoToProduct(productDto);
            Product product1 = productRepo.save(product);

                return new StringModel("created account");

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }


    }

    @Override
    public List<ProductDto> getAllProductsByLetters(String letters) {
        try{
      List<Product> products=  productRepo.getAllByDescribtionLikeAndNameLike(letters);
      List<ProductDto> productDtoList = ProductMapper.categoryMapper.convertProductToDto(products);
      if(productDtoList.isEmpty()){
          throw new RuntimeException("error.data");
      }
      return productDtoList;
        }catch (Exception e){
throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<ProductDto> getAllProducts(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Product> products = productRepo.findAll(pageable);
        List<Product> productList = products.stream().toList();
        return ProductMapper.categoryMapper.convertProductToDto(productList);
    }

    @Override
    public ProductDto getProductsByName(String name) {
        Product products = productRepo.findByName(name);
        return ProductMapper.categoryMapper.map(products);
    }

    @Override
    public List<Product> getProductsByIds(List<Long> ids) {
        return productRepo.findAllById(ids);
    }



    @Override
    public Integer getProductSizeS() {
   int sizes =  productRepo.getProductSize();
   return sizes;
    }

    @Override
    public Integer getProductSizeByIdS(Long id) {
       try{
       int size =     productRepo.getProductSizeById(id);
       return size;
       }catch (Exception e){
           throw new RuntimeException("error.data");
       }
    }


}

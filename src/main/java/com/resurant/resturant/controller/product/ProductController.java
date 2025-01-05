package com.resurant.resturant.controller.product;


import com.resurant.resturant.dto.ProductDto;
import com.resurant.resturant.dto.StringModel;
import com.resurant.resturant.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/all_products")
    public ResponseEntity<List<ProductDto>> getAllProducts(@RequestParam("page_number") int pageNumber,
                                                           @RequestParam("page_size") int pageSize) throws Exception {
        try {
            return ResponseEntity.ok(productService.getAllProducts(pageNumber,pageSize));
        } catch (Exception e) {
            throw new Exception("error.catch");
        }
    }

    @GetMapping("/all_products_by_id")
    public ResponseEntity<List<ProductDto>> getAllProductsById(@RequestParam("id") Long id) throws Exception {
        try {
            return ResponseEntity.ok(productService.getAllProductsByCategoryId(id));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/create_product")
    public ResponseEntity<StringModel> createProduct(@RequestBody ProductDto productDto) throws Exception {
        StringModel stringModel = productService.createProductService(productDto);
        return ResponseEntity.created(URI.create("/product/create_product")).body(stringModel);
    }

    @GetMapping("/get_all_products_by_letters")
    public ResponseEntity<List<ProductDto>> getAllProductsByLetters(@RequestParam("letters") String letters) {
        return ResponseEntity.ok(productService.getAllProductsByLetters(letters));

    }
    @GetMapping("/get_all_products_by_name")
    public ResponseEntity<ProductDto> getAllProductsByName(@RequestParam("name") String name){
        return ResponseEntity.ok(productService.getProductsByName(name));
    }
    @GetMapping("/get_product_size")
    public ResponseEntity<Integer> getProductSize(){
        return ResponseEntity.ok(productService.getProductSizeS());
    }
    @GetMapping("/get_product_size_by-id")
    public ResponseEntity<Integer> getProductSizeById(@RequestParam("id") Long id){
        return ResponseEntity.ok(productService.getProductSizeByIdS(id));
    }

}

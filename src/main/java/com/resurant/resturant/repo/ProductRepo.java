package com.resurant.resturant.repo;


import com.resurant.resturant.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    List<Product> findByCategory_Id(Long category_id);
@Query(value = "SELECT * FROM Product WHERE NAME LIKE %:letters% AND DESCRIBTION LIKE %:letters%",nativeQuery = true)
    List<Product> getAllByDescribtionLikeAndNameLike(@Param("letters") String letters);

Product findByName(String name);
@Query(value = "SELECT COUNT(ID) FROM PRODUCT",nativeQuery = true)
Integer getProductSize();
@Query(value = "SELECT COUNT(ID) FROM PRODUCT WHERE ID=:id",nativeQuery = true)
Integer getProductSizeById(@Param("id") Long id);
}

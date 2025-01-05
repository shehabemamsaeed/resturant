package com.resurant.resturant.repo;

import com.resurant.resturant.model.RequestOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<RequestOrder,Long> {

}

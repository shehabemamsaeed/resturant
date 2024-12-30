package com.resurant.resturant.repo;

import com.resurant.resturant.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client ,Long> {
 Client findByName(String name);
}

package com.resurant.resturant.repo;

import com.resurant.resturant.model.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<ContactInfo,Long> {
}

package com.resurant.resturant.repo;

import com.resurant.resturant.model.PhotoFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepo extends JpaRepository<PhotoFile,Long> {
}

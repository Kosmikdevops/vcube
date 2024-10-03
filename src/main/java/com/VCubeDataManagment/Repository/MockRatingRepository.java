package com.VCubeDataManagment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VCubeDataManagment.Entity.MockRating;

@Repository
public interface MockRatingRepository extends JpaRepository<MockRating, Long>{

}

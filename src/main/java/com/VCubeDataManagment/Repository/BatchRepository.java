package com.VCubeDataManagment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VCubeDataManagment.Entity.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long>{

}

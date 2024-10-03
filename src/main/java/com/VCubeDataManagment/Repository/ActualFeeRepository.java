package com.VCubeDataManagment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VCubeDataManagment.Entity.ActualFees;

@Repository
public interface ActualFeeRepository extends JpaRepository<ActualFees,Long>{

	
}

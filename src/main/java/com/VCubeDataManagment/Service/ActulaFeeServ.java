package com.VCubeDataManagment.Service;

import org.springframework.http.ResponseEntity;

import com.VCubeDataManagment.Entity.ActualFees;

public interface ActulaFeeServ {

	ResponseEntity<ActualFees> updateActualFee(ActualFees fee);
	
}

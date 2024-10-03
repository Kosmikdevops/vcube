package com.VCubeDataManagment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.VCubeDataManagment.Entity.ActualFees;
import com.VCubeDataManagment.Repository.ActualFeeRepository;

@Service
public class ActualFeesService implements ActulaFeeServ{

	@Autowired
	private ActualFeeRepository repo;

	@Override
	public ResponseEntity<ActualFees> updateActualFee(ActualFees fee) {
		ActualFees feesaftersave = repo.save(fee);
		return new ResponseEntity<ActualFees>(feesaftersave,HttpStatus.OK);
	}
	
	
}

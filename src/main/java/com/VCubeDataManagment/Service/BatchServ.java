package com.VCubeDataManagment.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.VCubeDataManagment.Dto.BatchDto;
import com.VCubeDataManagment.Entity.Batch;

public interface BatchServ {

	ResponseEntity<Batch> saveBatch(BatchDto batch);
	ResponseEntity<Batch> getBatchById(long id);
	ResponseEntity<List<Batch>> getAllBatches(); 
}

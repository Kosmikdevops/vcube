package com.VCubeDataManagment.Service;

import org.springframework.http.ResponseEntity;

import com.VCubeDataManagment.Dto.StudentDto;
import com.VCubeDataManagment.Entity.Batch;
import com.VCubeDataManagment.Entity.Student;

public interface Studentserv {

	ResponseEntity<Batch> saveStudent(StudentDto studentdto,Batch batch);
	ResponseEntity<Batch> getBatchByBatchId(long id);
}

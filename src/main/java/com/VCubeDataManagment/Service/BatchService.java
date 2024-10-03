package com.VCubeDataManagment.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.VCubeDataManagment.Dto.BatchDto;
import com.VCubeDataManagment.Entity.Batch;
import com.VCubeDataManagment.Entity.Course;
import com.VCubeDataManagment.Repository.BatchRepository;

@Service
public class BatchService implements BatchServ{

	@Autowired
	BatchRepository repo;
	@Autowired
	private CourseService courseservice;
	
	@Override
	public ResponseEntity<Batch> getBatchById(long id) {
		Optional<Batch> res = repo.findById(id);
		if(!res.isEmpty()) {
			return new ResponseEntity<Batch>(res.get(),HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Batch>(res.get(),HttpStatus.NOT_FOUND);
		}
		
	}

	@Override
	public ResponseEntity<Batch> saveBatch(BatchDto batch) {
		ResponseEntity<Course> courseByName = courseservice.getCourseByName(batch.getCoursename());
		Batch orginalbatch = new Batch();
		orginalbatch.setBatchname(batch.getBatchname());
		orginalbatch.setCourse(courseByName.getBody());
		orginalbatch.setStartingdate(batch.getStartingdate());
	    Batch bsave = repo.save(orginalbatch);
	
     return new ResponseEntity<Batch>(bsave,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Batch>> getAllBatches() {
		
		return new ResponseEntity<List<Batch>>(repo.findAll(),HttpStatus.OK);
	}
	
}

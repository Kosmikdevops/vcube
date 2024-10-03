package com.VCubeDataManagment.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.VCubeDataManagment.Entity.Course;
import com.VCubeDataManagment.Exceptionlayer.NoSuchCourseException;
import com.VCubeDataManagment.Repository.CourseRepository;

@Service
public class CourseService implements Courseserv{

	@Autowired
	private CourseRepository repo;
//	--------------------to save course----------------------
	@Override
	public ResponseEntity<String> savecourse(Course course) {
		Course res = repo.save(course);
		return new ResponseEntity<String>(res.getCoursename()+" is Registered successfully ",HttpStatus.OK);
	}
//	 ---------------to Get Course by Name---------------------
	@Override
	public ResponseEntity<Course> getCourseByName(String coursename) {
		Optional<Course> bycourseName = repo.findCourseByCName(coursename);
		if(bycourseName.isEmpty()) {
			throw new NoSuchCourseException(coursename +" : for this course name data is not found");
		}
		return new ResponseEntity<Course>(bycourseName.get(),HttpStatus.FOUND);
	}
	@Override
	public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> allcourses = repo.findAll();
		return new ResponseEntity<List<Course>>(allcourses,HttpStatus.OK);
	}
	@Override
	public ResponseEntity<Course> getCoursesById(long id) {
		Optional<Course> coursebyid = repo.findById(id);
		return new ResponseEntity<Course>(coursebyid.get(),HttpStatus.FOUND);
	}
	@Override
	public void getCoursesByIdAnddelete(long id) {
		ResponseEntity<Course> coursesById = getCoursesById(id);
		repo.delete(coursesById.getBody());
		
	}
	
	
	

}

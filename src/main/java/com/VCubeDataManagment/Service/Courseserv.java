package com.VCubeDataManagment.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.VCubeDataManagment.Entity.Course;

public interface Courseserv {

	ResponseEntity<String> savecourse(Course course);
	
	ResponseEntity<Course> getCourseByName(String coursename);
	
	ResponseEntity<List<Course>> getAllCourses();
	ResponseEntity<Course> getCoursesById(long id);
	void getCoursesByIdAnddelete(long id);
}

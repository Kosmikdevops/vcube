package com.VCubeDataManagment.Exceptionlayer;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class NoCourseforName {

	@ExceptionHandler(NoSuchCourseException.class)
	public ResponseEntity<CourseNotFound> forThisnamecourseisnotAvailable(CourseNotFound found){
		CourseNotFound courseNotFound = new CourseNotFound(found.getName(),new Date(),HttpStatus.NOT_FOUND);
		return new ResponseEntity<CourseNotFound>(courseNotFound,HttpStatus.NON_AUTHORITATIVE_INFORMATION);
	}
}

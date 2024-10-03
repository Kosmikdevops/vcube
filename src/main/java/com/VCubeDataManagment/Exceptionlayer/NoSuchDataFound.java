package com.VCubeDataManagment.Exceptionlayer;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class NoSuchDataFound {

	@ExceptionHandler(AdminDataisnotfound.class)
	public ResponseEntity<AdminNotFound> datanotfound(AdminNotFound found){
		
		AdminNotFound  res = new AdminNotFound (found.getName(), new Date(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<AdminNotFound>(res,HttpStatus.NOT_FOUND);
		
		
	}
}

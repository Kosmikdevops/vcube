package com.VCubeDataManagment.Exceptionlayer;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseNotFound {

	private String name;
	private Date date;
	private HttpStatus status;
}

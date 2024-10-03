package com.VCubeDataManagment.Exceptionlayer;



import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminNotFound {

	private String name;
	private Date date;
	private HttpStatus status;
	
}

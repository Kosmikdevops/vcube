package com.VCubeDataManagment.Dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

//	private long id;
	private String firstname;
	private String lastname;
	private Date dob;
	private String gender;
	private String email;
	private String password;
	private String phonenumber;
	private String address;
	private Date enrollmentdate;
//	private String other;
	private String qualification;
	private Date passedoutyear;
	private String GPA;
	private String coursename;
	private String Batchname;
	
}

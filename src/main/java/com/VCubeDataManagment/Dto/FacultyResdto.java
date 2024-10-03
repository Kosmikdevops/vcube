package com.VCubeDataManagment.Dto;

import java.sql.Date;

import com.VCubeDataManagment.Entity.Course;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacultyResdto {

	private long id;
	private String firstname;
	private String lastname;
	private Date dob;
	private String gender;
	private String email;
	private String phonenumber;
	private String password;
	private String address;
	private Date hiredate;
	private String experince;
	private double salary;
	private String status;
	private Course course;
//	private 
}

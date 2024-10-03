package com.VCubeDataManagment.Dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facultydto {

	
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
	private String coursename;
	private MultipartFile photo;
}

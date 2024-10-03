package com.VCubeDataManagment.Dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

	private long id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String phonenumber;
	private Date dateofjoin;
	private String status="Active";
}

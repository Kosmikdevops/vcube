package com.VCubeDataManagment.Entity;

import java.sql.Blob;
import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private String status="active";
	@ManyToOne(cascade = CascadeType.ALL)
	private Course course;
	@Lob
	private Blob image;
	
}

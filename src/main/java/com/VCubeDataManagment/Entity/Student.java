package com.VCubeDataManagment.Entity;

import java.sql.Date;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String firstname;
	private String lastname;
	private Date dob;
	private String gender;
	private String email;
	private String password;
	private String phonenumber;
	private String address;
	private Date enrollmentdate;
	private String studentno;
	private String qualification;
	private Date passedoutyear;
	private String cgpa;
	private String batchname;
	private String status="active";
	@OneToOne(cascade = CascadeType.ALL)
	private ActualFees fees=new ActualFees();
	@Lob
    private byte[] photo;
	@ManyToOne(cascade =CascadeType.ALL )
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	private Course course;
	
}

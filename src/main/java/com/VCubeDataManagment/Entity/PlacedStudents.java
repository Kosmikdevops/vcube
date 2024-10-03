package com.VCubeDataManagment.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlacedStudents {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String batchname;
	private String studentno;
	private String studentname;
	private Date placeddate;
	private String companyname;
	private String role;
	private double salary;
	@Lob
    private byte[] data;
	
}

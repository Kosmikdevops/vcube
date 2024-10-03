package com.VCubeDataManagment.Entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MockRating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String languagename;
	private String rating;
	@ManyToOne(cascade = CascadeType.ALL)
	private Student student;
}

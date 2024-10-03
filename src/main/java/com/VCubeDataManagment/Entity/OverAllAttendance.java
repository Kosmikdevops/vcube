package com.VCubeDataManagment.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OverAllAttendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long overallid;
	private long LabAttendence;
	private long WeeklyTestAttendence;
	private long caseStudy;
    private double OverAlresult;
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

}

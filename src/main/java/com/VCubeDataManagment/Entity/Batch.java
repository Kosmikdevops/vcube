package com.VCubeDataManagment.Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
	    private String Batchname;
	    private Date Startingdate;
	    private String status ="On going";
	    private String topicgoing;
	    private Long lastStudentNumber = 0L;
	    @ManyToMany(cascade = CascadeType.ALL)
	    private Set<Student> student=new LinkedHashSet<Student>();
	    @ManyToOne(cascade = CascadeType.ALL)
	    private Course course;
	    @OneToMany(cascade =CascadeType.ALL )
	    private List<Faculty> faculty=new ArrayList<>();
	    
}


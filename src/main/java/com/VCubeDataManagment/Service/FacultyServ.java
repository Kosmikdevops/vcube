package com.VCubeDataManagment.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.VCubeDataManagment.Dto.Facultydto;
//import com.VCubeDataManagment.Entity.Faculty;
import com.VCubeDataManagment.Entity.Faculty;

public interface FacultyServ {

	ResponseEntity<String> saveFaculty(Facultydto faculty) throws IOException;
	ResponseEntity<List<Faculty>> getAllfacultysinprovideCourse(String coursename);
	
	ResponseEntity<Faculty> getFacultyById(long id);
}

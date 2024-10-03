package com.VCubeDataManagment.Service;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.VCubeDataManagment.Dto.Facultydto;
import com.VCubeDataManagment.Entity.Course;
import com.VCubeDataManagment.Entity.Faculty;
import com.VCubeDataManagment.Repository.Facultyrepository;

@Service
public class FacultyService implements FacultyServ{

	@Autowired
	private Facultyrepository repo;
	@Autowired
	private CourseService courseservice;
//	--------------------save Faculty By name-------------------------
	@Override
	public ResponseEntity<String> saveFaculty(Facultydto facultydto) throws IOException {
		
		ResponseEntity<Course> courseByName = courseservice.getCourseByName(facultydto.getCoursename());
		Faculty faculty = new Faculty();
		byte[] bytes = facultydto.getPhoto().getBytes();
        Blob blob;
		try {
			blob = new javax.sql.rowset.serial.SerialBlob(bytes);
			faculty.setImage(blob);
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		faculty.setAddress(facultydto.getAddress());
		faculty.setCourse(courseByName.getBody());
		faculty.setDob(facultydto.getDob());
		faculty.setEmail(facultydto.getEmail());
		faculty.setExperince(facultydto.getExperince());
		faculty.setFirstname(facultydto.getFirstname());
		faculty.setGender(facultydto.getGender());
		faculty.setHiredate(facultydto.getHiredate());
		faculty.setLastname(facultydto.getLastname());
		faculty.setPhonenumber(facultydto.getPhonenumber());
		faculty.setPassword(facultydto.getPassword());
		faculty.setSalary(facultydto.getSalary());
		
		Faculty res = repo.save(faculty);
		
		return new ResponseEntity<String>(res.getFirstname()+"for this name registeration is success", HttpStatus.OK);
		
	}
	@Override
	public ResponseEntity<List<Faculty>> getAllfacultysinprovideCourse(String coursename) {
	  List<Faculty> faculty = repo.findFacultyByCourseName(coursename);
		return new ResponseEntity<List<Faculty>>(faculty,HttpStatus.FOUND);
	}
	@Override
	public ResponseEntity<Faculty> getFacultyById(long id) {
		Optional<Faculty> faculty = repo.findById(id);
		return new ResponseEntity<Faculty>(faculty.get(),HttpStatus.FOUND);
	}

}

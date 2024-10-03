package com.VCubeDataManagment.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.VCubeDataManagment.Dto.Facultydto;
import com.VCubeDataManagment.Entity.Faculty;
import com.VCubeDataManagment.Service.FacultyService;

@Controller
public class FacultyController {

	@Autowired
	private FacultyService service;
	@PostMapping("/saveFaculty")
	public String saveFaculty(@ModelAttribute Facultydto faculty) throws IOException{
		
		 service.saveFaculty(faculty);
		 return "redirect:/navigatetoFacultyhomepage1";
	
	}
//	-------------------------- get faculty home page ---------------------------
	@GetMapping("/navigatetoFacultyhomepage1")
	public String navigateTofacultyHomePage(Model model) {
		String s1="JavaFullStack";
		ResponseEntity<List<Faculty>> faculty = service.getAllfacultysinprovideCourse(s1);	
		model.addAttribute("facultyList", faculty.getBody());
		return "Facultyhomepage";
	}
	@GetMapping("/getFacultyRegisterpage")
	public String getFacultyREgisterpage() {
		
		return "AddNewFaculty";
	}
	
//  display image
 @GetMapping("/display")
 public ResponseEntity<byte[]> displayImage(@RequestParam("id") long id) throws IOException, SQLException
 { 
	 System.out.println("code is working-----------------------------------------------------------------");
	 ResponseEntity<Faculty> facultyById = service.getFacultyById(id);
	 Faculty fac = facultyById.getBody();
	    
	    byte [] imageBytes = null;
	     imageBytes = fac.getImage().getBytes(1,(int) fac.getImage().length());
     return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
 }
	
}

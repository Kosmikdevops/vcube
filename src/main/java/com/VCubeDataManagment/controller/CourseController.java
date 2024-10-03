package com.VCubeDataManagment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.VCubeDataManagment.Entity.Course;
import com.VCubeDataManagment.Service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService service;
	@PostMapping("/savecourse")
	public String saveCourse(@ModelAttribute Course course){
		 service.savecourse(course);
		 return "redirect:/getCourseHomePage";
		
	}
	@GetMapping("/getbycoursename")
	public ResponseEntity<Course> getByCourseName(String coursename){
		return service.getCourseByName(coursename);
	}
//	@GetMapping("/getCourseHomePage")
//	public static String GetCourseHomepage() {
//		return "CourseHomepage";
//	}
	@GetMapping("/getCourseregisterform")
	public String GetCourseRegisterform() {
		return "Add-NewCourse";
	}
	@GetMapping("getCourseHomePage")
	public String getAllCourses(Model model) {
		ResponseEntity<List<Course>> allCourses = service.getAllCourses();
		model.addAttribute("allcourse", allCourses.getBody());
		return "CourseHomepage";
	}
	@GetMapping("/getcourseByIdandEdit/{id}")
	public ModelAndView getCourseByIdAndEdit(@PathVariable long id) {
		ResponseEntity<Course> coursesById = service.getCoursesById(id);
		ModelAndView model = new ModelAndView("Edit-CourseDetails");
		model.addObject("coursebyid",coursesById.getBody());
		return model;
	}
	@GetMapping("/getcourseByIdandDelete/{id}")
	public String getCourseByIdAndDelete(@PathVariable long id) {
		service.getCoursesByIdAnddelete(id);
		return "redirect:/getCourseHomePage";
	}
	
}

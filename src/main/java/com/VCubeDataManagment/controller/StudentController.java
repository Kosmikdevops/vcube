package com.VCubeDataManagment.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.VCubeDataManagment.Dto.StudentDto;
import com.VCubeDataManagment.Entity.Batch;
import com.VCubeDataManagment.Entity.Student;
import com.VCubeDataManagment.Repository.BatchRepository;
import com.VCubeDataManagment.Service.BatchService;
import com.VCubeDataManagment.Service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	@Autowired
	private HttpSession session;
	@Autowired
	private BatchService batchservice;
	@Autowired
	private BatchRepository batchrepo;
//	get batch id by clicking on add Student 
	@RequestMapping("/byusingbatchidsaveStudent/{id}")
	public String getBatchId(@PathVariable long id) {
		ResponseEntity<Batch> byBatchId = service.getBatchByBatchId(id);
		System.out.println(byBatchId.getBody());
		session.setAttribute("currentbatch", byBatchId.getBody());
		return "StudentRegisterform";
	}

//	save Student by getting data from student register from 
	@PostMapping("/saveStudent")
	public String saveStudent(StudentDto studentdto) {
		
		Batch b=(Batch)session.getAttribute("currentbatch");
		System.out.println(b+" execution starts ");
		ResponseEntity<Batch> batchById = batchservice.getBatchById(b.getId());
		studentdto.setBatchname(b.getBatchname());
		 ResponseEntity<Batch> saveStudent12 = service.saveStudent(studentdto,batchById.getBody());
		 session.removeAttribute("currentbatch");
		 session.setAttribute("currentbatch", saveStudent12.getBody());
		 System.out.println("after execution -----------------------------"+saveStudent12);
		 return "redirect:/getAllStudents";
	}
//	Get All Students to display after added to batch 
	@GetMapping("/getAllStudents")
	public String getAllStudents(Model model) {
		Batch b=(Batch)session.getAttribute("currentbatch");
	    Optional<Batch> byid = batchrepo.findById(b.getId());
	       Set<Student> students = byid.get().getStudent();
	       model.addAttribute("AllStudents",students);
	       return "ShowAllStudents";
	}
//	Get List of Students when they click on get All STudents 
	@RequestMapping("/byusingbatchidshowStudent/{id}")
	public ModelAndView  getBatchIdandshowstudents(@PathVariable long id) {
		ResponseEntity<Batch> byBatchId = service.getBatchByBatchId(id);
//		System.out.println(byBatchId.getBody());
//		session.setAttribute("currentbatch", byBatchId.getBody());
		ModelAndView view = new ModelAndView("ShowAllStudents.html");
		view.addObject("AllStudents", byBatchId.getBody().getStudent());
		return view;
	}
}

package com.VCubeDataManagment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.VCubeDataManagment.Entity.Admin;
import com.VCubeDataManagment.Entity.AdminAccess;
import com.VCubeDataManagment.Entity.Batch;
import com.VCubeDataManagment.Entity.LoginModel;
import com.VCubeDataManagment.Service.AdminAccessService;
import com.VCubeDataManagment.Service.Adminservice;


import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	@Autowired
	private Adminservice service;
	@Autowired
	private HttpSession session;
	@Autowired
	private AdminAccessService accessservice;
	@GetMapping("/getdata")
	public String check() {
		return "working";
	}
//	------------------saveadminmethod------------------------
	@PostMapping("/saveadmin")
	public  ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin){
		
		return service.saveadmin(admin);
	}
//	------------------------LoginAdminByUsernameAndPassword-----------------------------------
//	@GetMapping("/loginadmin")
//	public ResponseEntity<Admin> findbyUsernameAndPassword(@RequestBody LoginModel model){
//		return service.findbyUserNameandPassword(model.getEmail(),model.getPassword());
//	}
	
//---------------------------------------------------------------------------------------------------------------	
	
//	return loginpage to frontend when programe runs
	@GetMapping("/")
	public String getLoginPage() {
		return "Login.html";
	}
//	-----------------------------------------------------------------------------------------------------
	@GetMapping("/navigatetoAdminhome")
	public String NaviagatetoAdmin() {
		return "AdminHome.html";
	}
	@GetMapping("/getAdmin2phasevalidition")
	public String getAdmin2PhaseValidition() {
		return "Admin-navigation";
	}
//	  this is to check who is login based on email and password
	@GetMapping("/checklogindetails")
	public String checkWhoisLogin(@ModelAttribute LoginModel model) {
		System.out.println("hofeho'fhewohfeffeyu9i0o-pytydyfghjklhjgfkl;jhgfxfhjklljghfdfhjkl;'lkjgfhjkl;'lkjhgfxkl99999999999999999999(((((((((((((((()))))))))))))))))))))))))))))))))))");
		try {
			System.out.println("working-------------------------------------");
		String role = model.getRole();
		if(role.equals("Admin")) {
			ResponseEntity<Admin> admininfo = service.findbyUserNameandPassword(model.getEmail(),model.getPassword());
			if(admininfo.getStatusCode()==HttpStatus.FOUND) {
				session.setAttribute("admininfo", admininfo);
				return "redirect:/getAdmin2phasevalidition";
			}
			
		}
		}catch(Exception e) {
			
		System.out.println(e);
		}
		return "redirect:/";
		
	}
	@GetMapping("/getAdmin2page")
	public String getAdmin2loginpage() {
		return "AdminLogin2";
	}
	@GetMapping("/verifyvalidadminornot")
	public String gotoAdminhome(@ModelAttribute AdminAccess access) {
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(access);
		try {
		AdminAccess admin = accessservice.checkAdminValidornot(access);
		if(admin.getUsername().equals("java")) {
			return "redirect:/getJavaAdminHomePage";
		}
		else if(admin.getUsername().equals("python")) {
			return "redirect:/getPythonAdminHomePage";
		}
		else if(admin.getUsername().equals("devops")) {
			return "redirect:/getDevopsAdminHomePage";
		}
		}catch(Exception e) {
			
		}
		return "redirect:/getAdmin2page";
		
		
	}
	@GetMapping("/getJavaAdminHomePage")
	public String GetJavaAdminHomePage() {
		return "javaAdminpage";
	}
	@GetMapping("/getPythonAdminHomePage")
	public String GetPythonAdminHomePage() {
		return "pyhtonAdminpage";
	}
	@GetMapping("/getDevopsAdminHomePage")
	public String GetDevopsAdminHomePage() {
		return "devopAdminPage";
	}
	
	
	
}

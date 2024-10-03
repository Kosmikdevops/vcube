package com.VCubeDataManagment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VCubeDataManagment.Dto.BatchDto;
import com.VCubeDataManagment.Entity.Batch;
import com.VCubeDataManagment.Service.BatchService;

@Controller
public class BatchController {

	@Autowired
	private BatchService service;
	@GetMapping("/gotobatchhome")
	public String goAdminHomepage() {
		return "Batchhome";
	}
	@GetMapping("/getbatchregisterpage")
	public String getBatchRegisterPage() {
		return "AddnewBatch";
	}
	
//	--------------------save Batch ------------------
	@PostMapping("/saveBatch")
	public String saveBatch(@ModelAttribute BatchDto batchdto) {
		
		ResponseEntity<Batch> saveBatch = service.saveBatch(batchdto);
		if(saveBatch.getStatusCode()==HttpStatus.OK) {
			return "Test";
		}
		else {
			return "redirect:/gotobatchhome";
		}
	}
	
//	------------------ getAllBatches-----------------
	@GetMapping("/getAllBatches")
	public String GetAllBatches(Model model) {
		ResponseEntity<List<Batch>> allBatches = service.getAllBatches();
		model.addAttribute("allbatches", allBatches.getBody());
		return "Batchhome";
	}
}

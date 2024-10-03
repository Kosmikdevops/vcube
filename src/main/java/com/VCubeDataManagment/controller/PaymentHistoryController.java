package com.VCubeDataManagment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PaymentHistoryController {

	@GetMapping("/getPaymentHistoryhomepage")
	public String getPaymentHistoryHomePage() {
		return "RecentTransactions";
	}
	@GetMapping("/getPayFeeHomePage")
	public String getPayFeeHomePage() {
		return "PayFeesesHomepage";
	}
}

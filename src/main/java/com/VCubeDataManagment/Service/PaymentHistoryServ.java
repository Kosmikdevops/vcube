package com.VCubeDataManagment.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.VCubeDataManagment.Entity.PaymentHistory;

public interface PaymentHistoryServ {

	ResponseEntity<PaymentHistory> PayFee(PaymentHistory history);
	
	ResponseEntity<List<PaymentHistory>> getAllPaymentsdoneByStudentbiId(long id);
}

package com.VCubeDataManagment.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.VCubeDataManagment.Entity.PaymentHistory;
import com.VCubeDataManagment.Repository.PaymentHistoryRepository;

@Service
public class PaymentHistoryService implements PaymentHistoryServ{

	@Autowired
	private PaymentHistoryRepository repo;
	@Override
	public ResponseEntity<PaymentHistory> PayFee(PaymentHistory history) {
		PaymentHistory feeaftersave = repo.save(history);
		
		return new ResponseEntity<PaymentHistory>(feeaftersave,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<PaymentHistory>> getAllPaymentsdoneByStudentbiId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

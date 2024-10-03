package com.VCubeDataManagment.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActualFees {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double totalamount=30000;
	private double paidtill=0;
	private String Paymentstatus="pending";
	
	
}


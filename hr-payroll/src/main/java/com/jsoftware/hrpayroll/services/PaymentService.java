package com.jsoftware.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.jsoftware.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workId, Integer days) {
		return new Payment("bob", 200.0, days);
	}
	
}

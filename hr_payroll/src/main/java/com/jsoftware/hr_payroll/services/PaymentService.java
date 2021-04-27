package com.jsoftware.hr_payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoftware.hr_payroll.config.WorkerFeignClient;
import com.jsoftware.hr_payroll.entities.Payment;
import com.jsoftware.hr_payroll.entities.Worker;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient feignClient;
	
	public Payment getPayment(Long workId, Integer days) {
		
		Worker worker = feignClient.findById(workId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	
	}
	
}

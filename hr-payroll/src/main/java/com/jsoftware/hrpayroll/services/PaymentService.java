package com.jsoftware.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jsoftware.hrpayroll.entities.Payment;
import com.jsoftware.hrpayroll.entities.Worker;

@Service
public class PaymentService {

	@Value("${hr-worker.host}") //Anotação que pega valores do arquivo application.properities
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(Long workId, Integer days) {
		
		Map<String, String> uri = new HashMap<>();
		uri.put("id", ""+workId);
		
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uri);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	
	}
	
}

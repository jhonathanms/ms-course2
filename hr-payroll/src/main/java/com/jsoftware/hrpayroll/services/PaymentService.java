package com.jsoftware.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoftware.hrpayroll.config.WorkerFeignClient;
import com.jsoftware.hrpayroll.entities.Payment;
import com.jsoftware.hrpayroll.entities.Worker;

@Service
public class PaymentService {

// Declaração utilizada em conjunto com RestTemplate	
//	@Value("${hr-worker.host}") //Anotação que pega valores do arquivo application.properties
//	private String workerHost;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private WorkerFeignClient feignClient;
	
	public Payment getPayment(Long workId, Integer days) {
		
// Declaração utilizada em conjunto com RestTemplate	
//		Map<String, String> uri = new HashMap<>();
//		uri.put("id", ""+workId);
		
//		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uri);
		
		Worker worker = feignClient.findById(workId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	
	}
	
}

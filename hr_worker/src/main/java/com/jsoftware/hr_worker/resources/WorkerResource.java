package com.jsoftware.hr_worker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsoftware.hr_worker.entities.Worker;
import com.jsoftware.hr_worker.repositories.WorkerRepository;

@RestController
@RequestMapping(value= "/workers")
public class WorkerResource {

	@Autowired
	private WorkerRepository repository;
	
	@Autowired
	private Environment env;
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> workers = repository.findAll();
		return ResponseEntity.ok().body(workers);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		
		// Imprime no logger do springboot a porta que a api está rodando
		logger.info(env.getProperty("local.server.port"));
		
		Worker worker = repository.findById(id).get();
		return ResponseEntity.ok().body(worker);
	}
	
}

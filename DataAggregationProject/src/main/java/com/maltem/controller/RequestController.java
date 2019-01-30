package com.maltem.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.maltem.dataRepo.DataRepo;
import com.maltem.model.RequestDetailMessage;
import com.maltem.service.UpdationTask;

@RestController
@RequestMapping(value = "/service")
public class RequestController {
	private static final Logger Logger = LoggerFactory.getLogger(RequestController.class);
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	public ApplicationEventPublisher eventPublisher;

	@GetMapping("doContinuousInput")
	public void getLiveAttributeDetails() throws InterruptedException, ExecutionException {
		ExecutorService nonBlockingService = Executors.newSingleThreadExecutor();
		Logger.info("Enter TaskDaoImpl method getLiveAttributeDetails: Param ");
		while (true) {
			Future<RequestDetailMessage> future = nonBlockingService
					.submit(new UpdationTask(restTemplate, DataRepo.getRandomObject()));
			Logger.info("Data Sent Succesfully"+future.get());
			Thread.sleep(900000);
		}
	}

}

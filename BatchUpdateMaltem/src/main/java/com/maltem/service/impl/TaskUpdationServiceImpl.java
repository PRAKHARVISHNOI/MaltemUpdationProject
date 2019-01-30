package com.maltem.service.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.maltem.dao.TaskDao;
import com.maltem.model.RequestDetailMessage;

@Service
public class TaskUpdationServiceImpl {
	private static final Logger Logger = LoggerFactory.getLogger(TaskUpdationServiceImpl.class);
	@Autowired
	TaskDao taskDao;
	
/*	@Value("${Therad_pool}")
	public Integer Therad_pool;*/
	
	ExecutorService executorService = Executors.newFixedThreadPool(100);

	public Boolean taskUpdation(RequestDetailMessage transactionDetailMessage) {
		Logger.info("Enter TaskUpdationServiceImpl method taskUpdation: Param # " + transactionDetailMessage);
		try {
			transactionDetailMessage.getUpdates().forEach(message -> {
				executorService.execute(new TaskUpdationService(taskDao, message));
			});
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}

package com.maltem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.maltem.exception.ApplicationException;
import com.maltem.model.RequestDetailMessage;
import com.maltem.model.ResponseDetailMessage;
import com.maltem.service.impl.TaskServiceImpl;

@RestController
public class DataController {

	private static final Logger Logger = LoggerFactory.getLogger(DataController.class);
	
	@Autowired
	TaskServiceImpl taskService;

	@PostMapping("/updateTask")
	@ResponseStatus(HttpStatus.OK)
	public RequestDetailMessage updateTask(@RequestBody RequestDetailMessage requestDetailMessage) {
		Logger.info("Enter DataController method RequestDetailMessage: Param # " + requestDetailMessage);
		if (taskService.updateMessage(requestDetailMessage)) {
			return requestDetailMessage;
		} else {
			return new RequestDetailMessage();
		}
		
	}

	@GetMapping("/startDate/{startDate}/endDate/{endDate}")
	public ResponseDetailMessage getData(@PathVariable String startDate, @PathVariable String endDate) throws ApplicationException {
		Logger.info("Enter DataController method getData: Param # #" + startDate +"-"+endDate);
		
		return taskService.getMessage(startDate, endDate);
	}

}

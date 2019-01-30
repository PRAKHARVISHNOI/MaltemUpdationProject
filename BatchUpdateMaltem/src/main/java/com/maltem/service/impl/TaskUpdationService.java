package com.maltem.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.maltem.dao.TaskDao;
import com.maltem.exception.ApplicationException;
import com.maltem.model.Message;

public class TaskUpdationService implements Runnable {

	
	private static final Logger Logger = LoggerFactory.getLogger(TaskUpdationService.class);
	TaskDao taskDao;

	Message message;

	public TaskUpdationService(TaskDao taskDao, Message message) {
		super();
		this.taskDao = taskDao;
		this.message = message;
	}

	@Override
	public void run() {
		try {
			
			taskDao.updateMessage(message);
		} catch (ApplicationException e) {
			Logger.info("Exception in TaskUpdationService" + e.getMessage());
			
		}
	}

}

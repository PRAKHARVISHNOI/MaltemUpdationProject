package com.maltem.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.maltem.controller.DataController;
import com.maltem.dao.TaskDao;
import com.maltem.exception.ApplicationException;
import com.maltem.model.Message;
import com.maltem.model.RequestDetailMessage;
import com.maltem.model.ResponseDetailMessage;
import com.maltem.service.TaskService;

@Service("TaskService")
public class TaskServiceImpl implements TaskService {
	private static final Logger Logger = LoggerFactory.getLogger(TaskServiceImpl.class);
	@Autowired
	TaskUpdationServiceImpl taskUpdationServiceImpl;

	@Autowired
	TaskDao taskDao;

	@Override
	public Boolean updateMessage(RequestDetailMessage transactionDetailMessage) {
		Logger.info("Enter TaskServiceImpl method updateMessage: Param # " + transactionDetailMessage);
		return taskUpdationServiceImpl.taskUpdation(transactionDetailMessage);
	}

	@Override
	public ResponseDetailMessage getMessage(String startTime, String endTime) throws ApplicationException {
		Logger.info("Enter TaskServiceImpl method getMessage: Param # " + startTime+"-"+endTime);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		ResponseDetailMessage transactionDetailMessage = new ResponseDetailMessage();
		List<Message> messageList;
		try {
			messageList = taskDao.getMessageList(sdf.parse(startTime).getTime(), sdf.parse(endTime).getTime());
			transactionDetailMessage.setTimeStamp(new Date().getTime());
			if (!CollectionUtils.isEmpty(messageList)) {
				transactionDetailMessage.setStatus("success");
				transactionDetailMessage.setUpdates(messageList);
			} else {
				transactionDetailMessage.setStatus("failure");
			}
		} catch (ParseException e) {
			throw new ApplicationException(e.getMessage());
		}
		return transactionDetailMessage;

	}

}

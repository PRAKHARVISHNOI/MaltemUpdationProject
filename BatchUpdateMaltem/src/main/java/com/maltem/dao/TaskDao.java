package com.maltem.dao;

import java.util.List;

import com.maltem.exception.ApplicationException;
import com.maltem.model.Message;

public interface TaskDao {

	Boolean updateMessage(Message message)throws ApplicationException;

	List<Message> getMessageList(Long stTime, Long endTime)throws ApplicationException;

}

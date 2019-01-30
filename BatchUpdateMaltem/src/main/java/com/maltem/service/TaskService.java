package com.maltem.service;

import com.maltem.exception.ApplicationException;
import com.maltem.model.RequestDetailMessage;
import com.maltem.model.ResponseDetailMessage;

public interface TaskService {

	Boolean updateMessage(RequestDetailMessage requestDetailMessage);

	ResponseDetailMessage getMessage(String startTime, String endTimne) throws ApplicationException;
}

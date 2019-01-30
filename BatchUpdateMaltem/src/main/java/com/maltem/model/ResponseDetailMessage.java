package com.maltem.model;

import java.util.List;

public class ResponseDetailMessage {
	private String status;
	private Long timeStamp;
	private List<Message> updates;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public List<Message> getUpdates() {
		return updates;
	}

	public void setUpdates(List<Message> updates) {
		this.updates = updates;
	}

}

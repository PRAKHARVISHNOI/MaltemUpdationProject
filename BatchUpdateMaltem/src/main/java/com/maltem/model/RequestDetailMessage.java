package com.maltem.model;

import java.util.List;

public class RequestDetailMessage {

	private String source;
	private Long timestamp;
	private List<Message> updates;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getTimeStamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public List<Message> getUpdates() {
		return updates;
	}

	public void setUpdates(List<Message> updates) {
		this.updates = updates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((updates == null) ? 0 : updates.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestDetailMessage other = (RequestDetailMessage) obj;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (updates == null) {
			if (other.updates != null)
				return false;
		} else if (!updates.equals(other.updates))
			return false;
		return true;
	}

}

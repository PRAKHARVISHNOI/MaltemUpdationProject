package com.maltem.model;

public class Message {

	private long id;
	private String name;
	private String git;
	private Long timestamp;

	public Message() {
		super();
	}

	public Message(String name, String git, Long timestamp) {
		super();
		this.name = name;
		this.git = git;
		this.timestamp = timestamp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGit() {
		return git;
	}

	public void setGit(String git) {
		this.git = git;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Message [name=" + name + ", git=" + git + ", timestamp=" + timestamp + "]";
	}

}

package com.trendyol.model;

public class EmailDTO {

	private UserDTO from;
	private UserDTO to;
	private String content;

	public EmailDTO(UserDTO from, UserDTO to, String content) {
		this.from = from;
		this.to = to;
		this.content = content;
	}

	public UserDTO getFrom() {
		return from;
	}

	public void setFrom(UserDTO from) {
		this.from = from;
	}

	public UserDTO getTo() {
		return to;
	}

	public void setTo(UserDTO to) {
		this.to = to;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}

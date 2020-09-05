package com.trendyol.model;

public class SmsDTO {

	private UserDTO sender;
	private UserDTO receiver;
	private String content;

	public SmsDTO(UserDTO sender, UserDTO receiver, String content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
	}

	public UserDTO getSender() {
		return sender;
	}

	public void setSender(UserDTO sender) {
		this.sender = sender;
	}

	public UserDTO getReceiver() {
		return receiver;
	}

	public void setReceiver(UserDTO receiver) {
		this.receiver = receiver;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}

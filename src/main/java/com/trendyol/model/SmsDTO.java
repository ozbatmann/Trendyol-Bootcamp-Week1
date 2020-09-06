package com.trendyol.model;

public class SmsDTO extends BaseInformationDTO {

	public SmsDTO(UserDTO sender, UserDTO receiver, String content) {
		super(sender, receiver, content);
	}
}

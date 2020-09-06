package com.trendyol.model;

public class EmailDTO extends BaseInformationDTO {

	public EmailDTO(UserDTO from, UserDTO to, String content) {
		super(from, to, content);
	}
}

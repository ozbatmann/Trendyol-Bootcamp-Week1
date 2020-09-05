package com.trendyol.service;

import com.trendyol.model.EmailDTO;
import com.trendyol.model.UserDTO;

public class EmailSender {

	private int MAX_EMAIL_COUNT = 10000;

	public EmailSender(int MAX_EMAIL_COUNT) {
		MAX_EMAIL_COUNT = MAX_EMAIL_COUNT;
	}

	public boolean validateEmailCount(UserDTO userDTO) {
		return userDTO.getEmailCount() < getMAX_EMAIL_COUNT();
	}

	public void sendEmail(EmailDTO emailDTO) {
		System.out.println("Sending email to " + emailDTO.getTo().getFullName() + " from " + emailDTO.getFrom().getFullName());
		emailDTO.getFrom().incEmailCnt();
	}

	public int getMAX_EMAIL_COUNT() {
		return MAX_EMAIL_COUNT;
	}
}

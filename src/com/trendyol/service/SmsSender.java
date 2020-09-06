package com.trendyol.service;

import com.trendyol.model.SmsDTO;
import com.trendyol.model.UserDTO;

public class SmsSender {

	private int MAX_SMS_COUNT;

	public SmsSender(int MAX_SMS_COUNT) {
		this.MAX_SMS_COUNT = MAX_SMS_COUNT;
	}

	public boolean validateSmsCount(UserDTO userDTO) {
		return userDTO.getSmsCount() < getMAX_SMS_COUNT();
	}

	public void sendSms(SmsDTO smsDTO) {
		System.out.println("Sending sms to " + smsDTO.getReceiver().getFullName());
		smsDTO.getSender().incSmsCnt();
	}

	public int getMAX_SMS_COUNT() {
		return MAX_SMS_COUNT;
	}
}

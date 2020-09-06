package com.trendyol.service;

import com.trendyol.model.BaseInformationDTO;

public class SmsInformationServiceImpl implements InformationService {

	private int MAX_SMS_COUNT;

	public SmsInformationServiceImpl(int MAX_SMS_COUNT) {
		this.MAX_SMS_COUNT = MAX_SMS_COUNT;
	}


	private int getMAX_SMS_COUNT() {
		return MAX_SMS_COUNT;
	}

	@Override
	public void sendInformation(BaseInformationDTO baseInformationDTO) {
		System.out.println("Sending sms to " + baseInformationDTO.getReceiver().getFullName());
		baseInformationDTO.getSender().incSmsCnt();
	}

	@Override
	public boolean validate(BaseInformationDTO baseInformationDTO) {
		return baseInformationDTO.getSender().getSmsCount() < getMAX_SMS_COUNT();
	}
}

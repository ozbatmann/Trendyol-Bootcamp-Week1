package com.trendyol.service;

import com.trendyol.model.BaseInformationDTO;

public class EmailInformationServiceImpl implements InformationService {

	private int MAX_EMAIL_COUNT = 10000;

	public EmailInformationServiceImpl(int MAX_EMAIL_COUNT) {
		MAX_EMAIL_COUNT = MAX_EMAIL_COUNT;
	}

	private int getMAX_EMAIL_COUNT() {
		return MAX_EMAIL_COUNT;
	}

	@Override
	public void sendInformation(BaseInformationDTO baseInformationDTO) {
		System.out.println("Sending email to " + baseInformationDTO.getReceiver().getFullName() + " from " + baseInformationDTO.getSender().getFullName());
		baseInformationDTO.getSender().incEmailCnt();
	}
	@Override
	public boolean validate(BaseInformationDTO baseInformationDTO) {
		return baseInformationDTO.getSender().getEmailCount() < getMAX_EMAIL_COUNT();
	}
}

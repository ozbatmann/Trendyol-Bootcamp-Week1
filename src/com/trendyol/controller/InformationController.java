package com.trendyol.controller;

import com.trendyol.model.BaseInformationDTO;
import com.trendyol.service.InformationService;

public class InformationController {

	private InformationService smsService;
	private InformationService emailService;

	public InformationController() {}

	public void sendSms(InformationService smsService) {
		this.smsService = smsService;
	}
	public void sendEmail(InformationService emailService) {
		this.emailService = emailService;
	}

}

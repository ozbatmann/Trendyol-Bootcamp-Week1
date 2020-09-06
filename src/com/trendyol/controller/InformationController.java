package com.trendyol.controller;

import com.trendyol.exception.InformationSendException;
import com.trendyol.model.BaseInformationDTO;
import com.trendyol.model.EmailDTO;
import com.trendyol.model.SmsDTO;
import com.trendyol.service.InformationService;

public class InformationController {

	private InformationService smsService;
	private InformationService emailService;

	public InformationController() {}

	public void sendSms(BaseInformationDTO baseInformationDTO) {
		try{
			if(smsService.validate(baseInformationDTO)) smsService.sendInformation(baseInformationDTO);
		} catch (InformationSendException e){
			e.printStackTrace();
		}
	}

	public void sendEmail(BaseInformationDTO baseInformationDTO) {
		try{
			if(emailService.validate(baseInformationDTO)) emailService.sendInformation(baseInformationDTO);
		} catch (InformationSendException e){
			e.printStackTrace();
		}

	}

	public InformationService getEmailService() {
		return emailService;
	}


	public void setEmailService(InformationService emailService) {
		this.emailService = emailService;
	}

	public InformationService getSmsService() {
		return smsService;
	}

	public void setSmsService(InformationService smsService) {
		this.smsService = smsService;
	}
}

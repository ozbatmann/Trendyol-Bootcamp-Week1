package com.trendyol.controller;

import com.trendyol.exception.InformationSendException;
import com.trendyol.model.BaseInformationDTO;
import com.trendyol.service.InformationService;

public class InformationController {

	private InformationService smsService;
	private InformationService emailService;

	public InformationController() {
	}

	public void setSmsService(InformationService smsService) {
		this.smsService = smsService;
	}

	public void setEmailService(InformationService emailService) {
		this.emailService = emailService;
	}

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

}

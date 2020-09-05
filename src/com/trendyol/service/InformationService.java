package com.trendyol.service;

import com.trendyol.model.EmailDTO;
import com.trendyol.model.SmsDTO;

public class InformationService {

	private SmsSender smsSender;

	private EmailSender emailSender;



	public InformationService(SmsSender smsSender, EmailSender emailSender) {
		this.smsSender = smsSender;
		this.emailSender = emailSender;
	}

	public void sendSms(SmsDTO smsDTO){
		if(smsSender.validateSmsCnt(smsDTO.getSender())) smsSender.sendSms(smsDTO);
		else System.out.println("Sms Validation Error Occured");

	}
	public void sendEmail(EmailDTO emailDTO){
		if(emailSender.validateEmailCount(emailDTO.getFrom())) emailSender.sendEmail(emailDTO);
		else System.out.println("Email Validation Error Occured");
	}
	public void sendSmsAndEmail(EmailDTO emailDTO, SmsDTO smsDTO){
		sendEmail(emailDTO);
		sendSms(smsDTO);
	}

}

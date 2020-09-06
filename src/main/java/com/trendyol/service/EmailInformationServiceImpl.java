package com.trendyol.service;

import com.trendyol.enums.ErrorMessage;
import com.trendyol.enums.LanguageEnum;
import com.trendyol.exception.InformationSendException;
import com.trendyol.model.BaseInformationDTO;

public class EmailInformationServiceImpl implements InformationService {

	private int MAX_EMAIL_COUNT;

	public EmailInformationServiceImpl(int MAX_EMAIL_COUNT) {
		this.MAX_EMAIL_COUNT = MAX_EMAIL_COUNT;
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
	public boolean validate(BaseInformationDTO baseInformationDTO) throws InformationSendException {
		if (baseInformationDTO.getSender().getEmailCount() < getMAX_EMAIL_COUNT()) {
			return true;
		}
		if (baseInformationDTO.getSender().getUserLanguage().equals(LanguageEnum.EN)) {
			throw new InformationSendException(ErrorMessage.Email_Error_En.getMessage());
		} else if (baseInformationDTO.getSender().getUserLanguage().equals(LanguageEnum.TR)) {
			throw new InformationSendException(ErrorMessage.Email_Error_Tr.getMessage());
		}
		return false ;
	}
}

package com.trendyol.service;

import com.trendyol.model.BaseInformationDTO;

public interface InformationService {

	public void sendInformation(BaseInformationDTO baseInformationDTO);

	public boolean validate(BaseInformationDTO baseInformationDTO);
}
package com.trendyol.model;

import com.trendyol.enums.ErrorMessage;
import com.trendyol.enums.LanguageEnum;

public class UserDTO {

	private String fullName;
	private String email;
	private String phone;

	private int smsCount;
	private int emailCount;

	private LanguageEnum userLanguage;

	public LanguageEnum getUserLanguage() {
		return userLanguage;
	}

	public void setUserLanguage(LanguageEnum userLanguage) {
		this.userLanguage = userLanguage;
	}

	public UserDTO(String fullName, String email, String phone, int smsCount, int emailCount, LanguageEnum userLanguage) {
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.smsCount = smsCount;
		this.emailCount = emailCount;
		this.userLanguage = userLanguage;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSmsCount() {
		return smsCount;
	}

	public void incSmsCnt() {
		this.smsCount++;
	}

	public int getEmailCount() {
		return emailCount;
	}

	public void incEmailCnt() {
		this.emailCount++;
	}
}

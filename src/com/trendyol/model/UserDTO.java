package com.trendyol.model;

public class UserDTO {

	private String fullName;
	private String email;
	private String phone;

	private int smsCount;
	private int emailCount;

	public UserDTO(String fullName, String email, String phone, int smsCount, int emailCount) {
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.smsCount = smsCount;
		this.emailCount = emailCount;
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

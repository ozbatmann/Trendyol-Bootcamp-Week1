package com.trendyol.enums;

public enum ErrorMessage {
    Sms_Error_Tr("Sms kotası aşıldı!"),
    Sms_Error_En("Sms validation limit exceeded!"),
    Email_Error_Tr("Email kotası aşıldı!"),
    Email_Error_En("Email validation limit exceeded!");

    String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


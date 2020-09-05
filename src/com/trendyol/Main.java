package com.trendyol;

import com.trendyol.model.EmailDTO;
import com.trendyol.model.SmsDTO;
import com.trendyol.model.UserDTO;
import com.trendyol.service.EmailSender;
import com.trendyol.service.InformationService;
import com.trendyol.service.SmsSender;

public class Main {

    public static void main(String[] args) {
        // write your code here

        EmailSender emailSender = new EmailSender(10000);
        SmsSender smsSender = new SmsSender(1000);

        InformationService informationService = new InformationService(smsSender,emailSender);

        UserDTO sender = new UserDTO("ali","ali@gmail.com","5051403166",0,0);
        UserDTO receiver = new UserDTO("veli","veli@gmail.com","5051403167",0,0);

        String content = "Sms content";
        SmsDTO smsDTO = new SmsDTO(sender,receiver,content);
        EmailDTO emailDTO = new EmailDTO(sender,receiver,content);

        for(int i = 0; i < 1001; i++){
            informationService.sendSms(smsDTO);
        }
        for(int i = 0; i < 10001; i++){
            informationService.sendEmail(emailDTO);
        }

    }
}

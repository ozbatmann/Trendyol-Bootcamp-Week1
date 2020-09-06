package com.trendyol.service;

import com.trendyol.model.*;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class InformationServiceTest {

    @Test
    public void it_should_increment_sms_count() {
        //Given
        SmsSender smsSender = new SmsSender(1000);
        InformationService informationService = new InformationService(smsSender,null);
        UserDTO sender = new UserDTO("ali","ali@gmail.com","5051403166",0,0);
        UserDTO receiver = new UserDTO("veli","veli@gmail.com","5051403167",0,0);
        SmsDTO sms = new SmsDTO(sender, receiver, "Hi, this is a sms");

        //When
        informationService.sendSms(sms);

        //Then
        assertEquals(1,sender.getSmsCount());
    }

    @Test
    public void it_should_increment_email_count() {
        //Given
        EmailSender emailSender = new EmailSender(10000);
        InformationService informationService = new InformationService(null,emailSender);
        UserDTO sender = new UserDTO("ali","ali@gmail.com","5051403166",0,0);
        UserDTO receiver = new UserDTO("veli","veli@gmail.com","5051403167",0,0);
        EmailDTO email = new EmailDTO(sender, receiver, "Hi, this is an email");

        //When
        informationService.sendEmail(email);

        //Then
        assertEquals(1,sender.getEmailCount());
    }

    @Test
    public void it_should_increment_both_sms_email_count() {
        //Given
        EmailSender emailSender = new EmailSender(10000);
        SmsSender smsSender = new SmsSender(1000);
        InformationService informationService = new InformationService(smsSender,emailSender);
        UserDTO sender = new UserDTO("ali","ali@gmail.com","5051403166",0,0);
        UserDTO receiver = new UserDTO("veli","veli@gmail.com","5051403167",0,0);
        EmailDTO email = new EmailDTO(sender, receiver, "Hi, this is an email");
        SmsDTO sms = new SmsDTO(sender, receiver, "Hi, this is a sms");

        //When
        informationService.sendSmsAndEmail(email,sms);

        //Then
        assertEquals(1,sender.getEmailCount());
        assertEquals(1,sender.getSmsCount());
    }

    @Test
    public void it_should_not_send_sms_when_max_exceeded() {
        //Given
        SmsSender smsSender = new SmsSender(1000);
        InformationService informationService = new InformationService(smsSender,null);
        UserDTO sender = new UserDTO("ali","ali@gmail.com","5051403166",smsSender.getMAX_SMS_COUNT(),0);
        UserDTO receiver = new UserDTO("veli","veli@gmail.com","5051403167",0,0);
        SmsDTO sms = new SmsDTO(sender, receiver, "Hi, this is a sms");

        //When
        informationService.sendSms(sms);

        //Then
        assertEquals(smsSender.getMAX_SMS_COUNT(),sender.getSmsCount());
    }

    @Test
    public void it_should_not_send_email_when_max_exceeded() {
        //Given
        EmailSender emailSender = new EmailSender(10000);
        InformationService informationService = new InformationService(null,emailSender);
        UserDTO sender = new UserDTO("ali","ali@gmail.com","5051403166",0,emailSender.getMAX_EMAIL_COUNT());
        UserDTO receiver = new UserDTO("veli","veli@gmail.com","5051403167",0,0);
        EmailDTO email = new EmailDTO(sender, receiver, "Hi, this is an email");

        //When
        informationService.sendEmail(email);

        //Then
        assertEquals(emailSender.getMAX_EMAIL_COUNT(),sender.getEmailCount());
    }

    @Test
    public void it_should_not_send_email_or_sms_when_max_exceeded() {
        //Given
        EmailSender emailSender = new EmailSender(10000);
        SmsSender smsSender = new SmsSender(1000);
        InformationService informationService = new InformationService(smsSender,emailSender);
        UserDTO sender = new UserDTO("ali","ali@gmail.com","5051403166",smsSender.getMAX_SMS_COUNT(),emailSender.getMAX_EMAIL_COUNT());
        UserDTO receiver = new UserDTO("veli","veli@gmail.com","5051403167",0,0);
        EmailDTO email = new EmailDTO(sender, receiver, "Hi, this is an email");
        SmsDTO sms = new SmsDTO(sender, receiver, "Hi, this is a sms");

        //When
        informationService.sendSmsAndEmail(email, sms);

        //Then
        assertEquals(emailSender.getMAX_EMAIL_COUNT(),sender.getEmailCount());
        assertEquals(smsSender.getMAX_SMS_COUNT(),sender.getSmsCount());
    }

    @Test
    public void it_should_send_sms_when_only_email_max_exceeded() {
        //Given
        EmailSender emailSender = new EmailSender(10000);
        SmsSender smsSender = new SmsSender(1000);
        InformationService informationService = new InformationService(smsSender,emailSender);
        UserDTO sender = new UserDTO("ali","ali@gmail.com","5051403166",999,emailSender.getMAX_EMAIL_COUNT());
        UserDTO receiver = new UserDTO("veli","veli@gmail.com","5051403167",0,0);
        EmailDTO email = new EmailDTO(sender, receiver, "Hi, this is an email");
        SmsDTO sms = new SmsDTO(sender, receiver, "Hi, this is a sms");

        //When
        informationService.sendSmsAndEmail(email, sms);

        //Then
        assertEquals(emailSender.getMAX_EMAIL_COUNT(),sender.getEmailCount());
        assertEquals(1000,sender.getSmsCount());
    }

    @Test
    public void it_should_send_email_when_only_sms_max_exceeded() {
        //Given
        EmailSender emailSender = new EmailSender(10000);
        SmsSender smsSender = new SmsSender(1000);
        InformationService informationService = new InformationService(smsSender,emailSender);
        UserDTO sender = new UserDTO("ali","ali@gmail.com","5051403166",smsSender.getMAX_SMS_COUNT(),9999);
        UserDTO receiver = new UserDTO("veli","veli@gmail.com","5051403167",0,0);
        EmailDTO email = new EmailDTO(sender, receiver, "Hi, this is an email");
        SmsDTO sms = new SmsDTO(sender, receiver, "Hi, this is a sms");

        //When
        informationService.sendSmsAndEmail(email, sms);

        //Then
        assertEquals(10000,sender.getEmailCount());
        assertEquals(smsSender.getMAX_SMS_COUNT(),sender.getSmsCount());
    }

}

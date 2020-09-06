package com.trendyol.service;

import com.trendyol.controller.InformationController;
import com.trendyol.enums.LanguageEnum;
import com.trendyol.exception.InformationSendException;
import com.trendyol.model.*;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class InformationServiceTest {

    @Test
    public void it_should_throw_exception_when_exceeded_max_email() {/*
        //Given
        InformationService emailSender = new EmailInformationServiceImpl(10);

        InformationController informationController = new InformationController();

        UserDTO sender = new UserDTO("ali", "ali@gmail.com", "5051403166", 0,0,LanguageEnum.TR);
        UserDTO receiver = new UserDTO("veli", "veli@gmail.com", "5051403167", 0, 0,LanguageEnum.TR);

        String content = "Email content";
        EmailDTO emailDTO = new EmailDTO(sender, receiver, content);

        informationController.setEmailService(emailSender);
        informationController.sendEmail(emailDTO);

        //When
        Throwable throwable = catchThrowable(() -> emailSender.validate(emailDTO));

        //Then
        org.junit.Assert.assertThat(throwable).isNotNull();
        assertThat(throwable).isInstanceOf(InformationSendException.class);
        assertThat(throwable).hasMessageContaining("Email validation error occured");*/
    }

}
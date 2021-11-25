package com.ricemarch.accessemail.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MailServiceImplTest {

    @Autowired
    MailService mailService;

    @Test
    void sendSalesTrackingReport() throws MessagingException {
        mailService.sendSalesTrackingReport(new Date());
    }
}
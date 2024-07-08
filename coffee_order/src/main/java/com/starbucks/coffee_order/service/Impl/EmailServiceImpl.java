package com.starbucks.coffee_order.service.Impl;

import com.starbucks.coffee_order.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class EmailServiceImpl implements EmailService {


    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String to, String subject, String text) throws MessagingException, jakarta.mail.MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("17763099645@163.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);

        javaMailSender.send(message);
    }
}

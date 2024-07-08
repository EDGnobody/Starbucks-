package com.starbucks.coffee_order.service;

import javax.mail.MessagingException;

public interface EmailService {
    void sendEmail(String to, String subject, String text) throws MessagingException, jakarta.mail.MessagingException;
}

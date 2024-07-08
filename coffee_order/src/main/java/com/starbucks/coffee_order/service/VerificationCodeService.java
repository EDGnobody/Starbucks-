package com.starbucks.coffee_order.service;

public interface VerificationCodeService {
    String generateCode(String email);
    boolean verifyCode(String email, String code);
    void invalidateCode(String email);
}

package com.starbucks.coffee_order.service.Impl;

import com.starbucks.coffee_order.mapper.VerificationMapper;
import com.starbucks.coffee_order.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    private final Map<String, String> verificationCodes = new HashMap<>();

    @Override
    public String generateCode(String email) {
        String code = String.valueOf(new Random().nextInt(999999));
        verificationCodes.put(email, code);
        return code;
    }

    @Override
    public boolean verifyCode(String email, String code) {
        return code.equals(verificationCodes.get(email));
    }

    @Override
    public void invalidateCode(String email) {
        verificationCodes.remove(email);
    }
}

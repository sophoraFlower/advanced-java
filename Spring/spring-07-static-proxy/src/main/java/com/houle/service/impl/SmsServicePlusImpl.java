package com.houle.service.impl;

import com.houle.service.SmsService;

public class SmsServicePlusImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("plus send message: " + message);
        return message;
    }
}

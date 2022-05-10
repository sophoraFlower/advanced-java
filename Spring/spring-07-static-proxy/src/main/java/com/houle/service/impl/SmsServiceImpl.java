package com.houle.service.impl;

import com.houle.service.SmsService;

public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message: " + message);
        return message;
    }
}

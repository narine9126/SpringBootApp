package com.sp.practice.SpringBootApp.service.notification;

import org.springframework.stereotype.Service;

@Service("smsNotification")
public class SMSNotification implements NotificationService{
    @Override
    public void sendNotification() {
        System.out.println("sending SMS notification ...");
    }
}

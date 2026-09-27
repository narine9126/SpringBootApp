package com.sp.practice.SpringBootApp.service.notification;

import org.springframework.stereotype.Service;

@Service("emailNotification")
public class EmailNotification implements NotificationService{
    @Override
    public void sendNotification() {
        System.out.println("sending Email notification ...");
    }
}

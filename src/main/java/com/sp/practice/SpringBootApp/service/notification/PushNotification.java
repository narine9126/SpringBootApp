package com.sp.practice.SpringBootApp.service.notification;

import org.springframework.stereotype.Service;

@Service
public class PushNotification implements NotificationService{
    @Override
    public void sendNotification() {
        System.out.println("sending push notification ....");
    }
}

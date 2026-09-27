package com.sp.practice.SpringBootApp.service;

import com.sp.practice.SpringBootApp.beans.MyEntity;
import com.sp.practice.SpringBootApp.repository.MyRepository;
import com.sp.practice.SpringBootApp.service.notification.NotificationService;
import com.sp.practice.SpringBootApp.service.notification.PushNotification;
import com.sp.practice.SpringBootApp.service.payments.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;

@Service
public class MyService {
    private final MyRepository repository;
    private final MyService1 service1;
    private final MyService2 service2;

    private final PaymentService paymentService;// default PaypalPaymentService bean initialized and No need to use @Autowired.
    private final PaymentService stripeService;// if you need to use Stripe PaymentService occasionally then use @Qualifier to specifically mention which service to inject.

    private final NotificationService emailNotification;
    private final NotificationService smsNotification;

    private final HttpClient paymentClient;
    private final HttpClient notificationClient;

    private PushNotification pushNotification;

    // Constructor dependency injection allows Max 7 services to Initialization, if it exceeds then refactor to another service based on business function.
    public MyService(MyRepository repository,
                     MyService1 service1,
                     MyService2 service2,
                     PaymentService paymentService,
                     @Qualifier("stripePaymentService") PaymentService stripeService,
                     @Qualifier("emailNotification") NotificationService emailNotification,
                     @Qualifier("smsNotification") NotificationService smsNotification,
                     @Qualifier("paymentClient") HttpClient paymentClient,
                     @Qualifier("notificationClient") HttpClient notificationClient
                     ){
        this.repository=repository;
        this.service1=service1;
        this.service2=service2;
        this.paymentService=paymentService;
        this.stripeService=stripeService;
        this.emailNotification=emailNotification;
        this.smsNotification=smsNotification;
        this.paymentClient=paymentClient;
        this.notificationClient=notificationClient;
    }

    @Autowired
    public void setPushNotification(PushNotification pushNotification) {
        this.pushNotification = pushNotification;
    }

    public MyEntity getEntity(Long beanId){
        return repository.findById(beanId).get();
    }

    public void processPayPalPayment(){
        paymentService.processPayment();
    }

    public void processStripePayment(){
        stripeService.processPayment();
    }

    public void sendEmailNotification(){
        emailNotification.sendNotification();
    }

    public void sendSMSNotification(){
        smsNotification.sendNotification();
    }

}

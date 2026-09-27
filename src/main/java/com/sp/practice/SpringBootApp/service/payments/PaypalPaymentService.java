package com.sp.practice.SpringBootApp.service.payments;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PaypalPaymentService implements PaymentService{
    @Override
    public void processPayment() {
        System.out.println("processing Paypal payment....");
    }
}

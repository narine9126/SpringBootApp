package com.sp.practice.SpringBootApp.service.payments;

import org.springframework.stereotype.Service;

@Service("stripePaymentService")
public class StripePaymentService implements PaymentService{
    @Override
    public void processPayment() {
        System.out.println("processing Paypal payment....");
    }
}

package com.sp.practice.SpringBootApp.service;

import org.springframework.stereotype.Component;

@Component
public class MyService2 {

    MyService1 service1;
    public MyService2(MyService1 service1){
        this.service1=service1;
    }
}

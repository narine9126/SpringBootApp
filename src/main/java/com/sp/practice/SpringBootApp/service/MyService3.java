package com.sp.practice.SpringBootApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Circular Dependency Injection
@Component
public class MyService3 {

    private MyService4 myService4;

    @Autowired
    public void setMyService4(MyService4 myService4) {
        this.myService4 = myService4;
    }
}

package com.sp.practice.SpringBootApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class MyService4 {

    private MyService3 myService3;

    @Autowired
    public void setMyService3( @Lazy MyService3 myService3) { // solving Circular DI using @Lazy annotation make bean initialization late.
        this.myService3 = myService3;
    }
}

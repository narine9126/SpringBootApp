package com.sp.practice.SpringBootApp.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class MyService1 {
    MyService2 service2;
    // Leads to Circular Dependency (CD) while initializing components, we can use @Lazy annotation to delay component initialization time.
    // This annotation just changes components initialization time to make application run, but do not solve the CD itself.
    // The Ideal way to solve CD is to design a components which do not depend on each.
    // If there is a common functionality then move that functionality to common service(ex: CommonService) then use constructor injection to initialize that component.
    public MyService1(@Lazy MyService2 service2){
        this.service2=service2;
    }
     /*
     @Component
     class CommonService{
          some common code
     }
     @Component
     class MyService1{
       CommonService commonservice;
       public MyService1(CommonService commonservice){
           this.commonservice=commonservice;
       }
     }
     @Component
     class MyService2{
       CommonService commonservice;
       public MyService2(CommonService commonservice){
           this.commonservice=commonservice;
       }
     */
}

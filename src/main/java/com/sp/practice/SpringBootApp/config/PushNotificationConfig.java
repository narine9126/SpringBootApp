package com.sp.practice.SpringBootApp.config;

import com.sp.practice.SpringBootApp.service.notification.PushNotification;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "push.notification.enabled", havingValue = "true")
// If push.notification.enabled is true in application.properties/application.yml
// then only PushNotificationConfig bean will be instantiated, and it will create PushNotification bean.
public class PushNotificationConfig {
 @Bean
 public PushNotification pushNotification(){
     return new PushNotification();
 }
}

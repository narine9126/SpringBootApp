package com.sp.practice.SpringBootApp.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.net.http.HttpClient;
import java.time.Duration;

@Configuration
public class HttpClientConfig {

    @Bean
    //@Qualifier("paymentClient")
    public HttpClient paymentClient(){
        return HttpClient.newBuilder()
                .connectTimeout(Duration.ofMillis(5000))
                .build();
    }

    @Bean
    //@Qualifier("notificationClient")
    public HttpClient notificationClient(){
        return HttpClient.newBuilder()
                .connectTimeout(Duration.ofMillis(10000))
                .build();
    }

}

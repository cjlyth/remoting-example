package com.cjlyth.remoting.example.client;

import com.cjlyth.remoting.example.api.CarService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

/**
 * Created by cjlyth on 7/28/16.
 */
public class Application {

    @Bean
    HttpInvokerProxyFactoryBean carService(@Value("${service.url}") String serviceUrl){
        HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean();
        proxy.setServiceInterface(CarService.class);
        proxy.setServiceUrl(serviceUrl);
        return proxy;
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}

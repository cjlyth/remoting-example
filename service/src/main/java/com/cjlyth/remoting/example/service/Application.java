package com.cjlyth.remoting.example.service;

import com.cjlyth.remoting.example.api.CarService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

/**
 * Created by cjlyth on 7/28/16.
 */
@SpringBootApplication
public class Application {

    @Bean(name = "/carService")
    HttpInvokerServiceExporter carService(CarService carService){
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setServiceInterface(CarService.class);
        exporter.setService(carService);
        return exporter;
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}

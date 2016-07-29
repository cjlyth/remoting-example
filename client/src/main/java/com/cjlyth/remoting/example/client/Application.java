package com.cjlyth.remoting.example.client;

import com.cjlyth.remoting.example.api.CarService;
import com.cjlyth.remoting.example.model.Car;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;


/**
 * Created by cjlyth on 7/28/16.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Bean
    HttpInvokerProxyFactoryBean carService(@Value("${service.url}") String serviceUrl){
        HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean();
        proxy.setServiceInterface(CarService.class);
        proxy.setServiceUrl(serviceUrl);
        return proxy;
    }

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private CarService carService;

    @Override
    public void run(String... args) {
        Car car = carService.getCar();
        logger.debug("Got Car: \n{} \nwith engine {}",
                reflectionToString(car, ToStringStyle.MULTI_LINE_STYLE),
                reflectionToString(car.getEngine(), ToStringStyle.MULTI_LINE_STYLE));
        if (args.length > 0 && args[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}

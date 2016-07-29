package com.cjlyth.remoting.example.client;

import com.cjlyth.remoting.example.api.CarService;
import com.cjlyth.remoting.example.model.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by cjlyth on 7/28/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
    @Autowired
    CarService carService;
    @Test
    public void carService() throws Exception {
        assertNotNull(carService);
        Car car = carService.getCar();
        assertNotNull(car);
    }

}
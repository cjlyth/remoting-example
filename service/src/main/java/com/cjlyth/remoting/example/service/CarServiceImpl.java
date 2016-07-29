package com.cjlyth.remoting.example.service;

import com.cjlyth.remoting.example.api.CarService;
import com.cjlyth.remoting.example.model.Car;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

/**
 * Created by cjlyth on 7/28/16.
 */
@Service
public class CarServiceImpl implements CarService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Car getCar() {
        Car car = new Car();
        car.setEngine(new GasEngine());
        logger.debug("Returning Car: \n{} \nwith engine {}",
                reflectionToString(car, ToStringStyle.MULTI_LINE_STYLE),
                reflectionToString(car.getEngine(), ToStringStyle.MULTI_LINE_STYLE));
        return car;
    }

    @Override
    public void setCar(Car car) {
        logger.debug("Setting Car: \n{} \nwith engine {}",
                reflectionToString(car, ToStringStyle.MULTI_LINE_STYLE),
                reflectionToString(car.getEngine(), ToStringStyle.MULTI_LINE_STYLE));
    }
}

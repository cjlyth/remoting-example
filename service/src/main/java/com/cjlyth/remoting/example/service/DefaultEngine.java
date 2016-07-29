package com.cjlyth.remoting.example.service;

import com.cjlyth.remoting.example.model.Engine;

/**
 * Created by cjlyth on 7/28/16.
 */
public class DefaultEngine implements Engine {
    @Override
    public double getHorsepower() {
        return 200;
    }
}

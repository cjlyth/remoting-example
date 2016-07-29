package com.cjlyth.remoting.example.client;

import com.cjlyth.remoting.example.model.Engine;

/**
 * Created by cjlyth on 7/28/16.
 */
public class HybridEngine implements Engine {
    @Override
    public double getHorsepower() {
        return 90;
    }
}

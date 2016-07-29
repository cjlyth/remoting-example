package com.cjlyth.remoting.example.model;

import java.io.Serializable;

/**
 * Created by cjlyth on 7/28/16.
 */
public class Car implements Serializable {
    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public <T extends Engine> void setEngine(T engine) {
        this.engine = engine;
    }


}

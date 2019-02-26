package com.geekbrains.androidlesson;

import java.io.Serializable;

public class SecondActivityParams implements Serializable {
    private final String name;
    private final Boolean hum;
    private final Boolean overc;
    private final Boolean speed;

    public SecondActivityParams(String name, Boolean hum, Boolean overc, Boolean speed) {
        this.name = name;
        this.hum = hum;
        this.overc = overc;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public Boolean getHum() {
        return hum;
    }

    public Boolean getOverc() {
        return overc;
    }

    public Boolean getSpeed() {
        return speed;
    }
}

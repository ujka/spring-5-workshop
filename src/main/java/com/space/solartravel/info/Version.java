package com.space.solartravel.info;

import org.springframework.stereotype.Component;

@Component
public class Version {

    private String version = "0.0.1";

    @Override
    public String toString() {
        return version;
    }
}
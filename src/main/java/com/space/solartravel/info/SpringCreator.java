package com.space.solartravel.info;

import org.springframework.stereotype.Component;

@Component
public class SpringCreator {

    private String creator = "Rod Johnson";

    @Override
    public String toString() {
        return creator;
    }
}
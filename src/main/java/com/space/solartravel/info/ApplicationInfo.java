package com.space.solartravel.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInfo {

    @Autowired
    private Version version;
    private SystemType systemType;
    private SpringCreator springCreator;

    public ApplicationInfo(SpringCreator springCreator) {
        this.springCreator = springCreator;
    }

    public void setSystemType(SystemType systemType) {
        this.systemType = systemType;
    }

    @Override
    public String toString() {
        return "ApplicationInfo{" +
                "version=" + version +
                ", systemType=" + systemType +
                ", springCreator=" + springCreator +
                '}';
    }
}

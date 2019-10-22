package com.space.solartravel.info;

public class ApplicationInfo {

    private Version version = new Version();
    private SystemType systemType;
    private SpringCreator springCreator;

    public ApplicationInfo(SpringCreator springCreator) {
        this.springCreator = springCreator;
    }

    public void setSystemType(SystemType systemType) {
        this.systemType = systemType;
    }
}

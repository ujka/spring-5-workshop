package com.space.solartravel.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ApplicationInfo {

    @Autowired
    private Environment environment;

    private Version version;
    private SystemType systemType;
    private SpringCreator springCreator;

    public ApplicationInfo(Version version, SpringCreator springCreator) {
        this.version = version;
        this.springCreator = springCreator;
    }

    public String getJavaHome() {
        return environment.getProperty("JAVA_HOME");
    }

    @Autowired(required = false)
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

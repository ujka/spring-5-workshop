package com.space.solartravel.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:security.properties")
@ConfigurationProperties(prefix = "security")
public class SpaceSecurityConfiguration {

    private boolean staticCheck;
    private Cacheable cacheable;
    private String urlAccess;
    private String signKey;

    public boolean isStaticCheck() {
        return staticCheck;
    }

    public void setStaticCheck(boolean staticCheck) {
        this.staticCheck = staticCheck;
    }

    public Cacheable getCacheable() {
        return cacheable;
    }

    public void setCacheable(Cacheable cacheable) {
        this.cacheable = cacheable;
    }

    public String getUrlAccess() {
        return urlAccess;
    }

    public void setUrlAccess(String urlAccess) {
        this.urlAccess = urlAccess;
    }

    public String getSignKey() {
        return signKey;
    }

    public void setSignKey(String signKey) {
        this.signKey = signKey;
    }

    @Override
    public String toString() {
        return "SpaceSecurityConfiguration{" +
                "staticCheck=" + staticCheck +
                ", cacheable=" + cacheable +
                ", urlAccess='" + urlAccess + '\'' +
                ", signKey='" + signKey + '\'' +
                '}';
    }
}

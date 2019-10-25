package com.space.solartravel.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration("spaceSystemConfiguration")
@PropertySource("classpath:configuration.properties")
@ConfigurationProperties(prefix = "system")
public class SpaceSystemConfiguration {

    private String bootUpStyle;
    private String restartStyle;
    private int maxNodes;
    private boolean goLive;
    private List<String> securedTerminals;
    private Help help;

    public String getBootUpStyle() {
        return bootUpStyle;
    }

    public void setBootUpStyle(String bootUpStyle) {
        this.bootUpStyle = bootUpStyle;
    }

    public String getRestartStyle() {
        return restartStyle;
    }

    public void setRestartStyle(String restartStyle) {
        this.restartStyle = restartStyle;
    }

    public int getMaxNodes() {
        return maxNodes;
    }

    public void setMaxNodes(int maxNodes) {
        this.maxNodes = maxNodes;
    }

    public boolean isGoLive() {
        return goLive;
    }

    public void setGoLive(boolean goLive) {
        this.goLive = goLive;
    }

    public List<String> getSecuredTerminals() {
        return securedTerminals;
    }

    public void setSecuredTerminals(List<String> securedTerminals) {
        this.securedTerminals = securedTerminals;
    }

    public Help getHelp() {
        return help;
    }

    public void setHelp(Help help) {
        this.help = help;
    }

    @Override
    public String toString() {
        return "SystemConfiguration{" +
                "bootUpStyle='" + bootUpStyle + '\'' +
                ", restartStyle='" + restartStyle + '\'' +
                ", maxNodes=" + maxNodes +
                ", goLive=" + goLive +
                ", securedTerminals=" + securedTerminals +
                ", help=" + help +
                '}';
    }
}

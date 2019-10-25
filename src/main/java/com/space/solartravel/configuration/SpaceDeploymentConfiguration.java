package com.space.solartravel.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource("classpath:configuration.properties")
@ConfigurationProperties(prefix = "deployment")
public class SpaceDeploymentConfiguration {

    private String devopsSupport;
    private DockerImage dockerImage;
    private int numberOfNods;
    private List<String> nodeNames;

    public String getDevopsSupport() {
        return devopsSupport;
    }

    public void setDevopsSupport(String devopsSupport) {
        this.devopsSupport = devopsSupport;
    }

    public DockerImage getDockerImage() {
        return dockerImage;
    }

    public void setDockerImage(DockerImage dockerImage) {
        this.dockerImage = dockerImage;
    }

    public int getNumberOfNods() {
        return numberOfNods;
    }

    public void setNumberOfNods(int numberOfNods) {
        this.numberOfNods = numberOfNods;
    }

    public List<String> getNodeNames() {
        return nodeNames;
    }

    public void setNodeNames(List<String> nodeNames) {
        this.nodeNames = nodeNames;
    }

    @Override
    public String toString() {
        return "SpaceDeploymentConfiguration{" +
                "devopsSupport='" + devopsSupport + '\'' +
                ", dockerImage=" + dockerImage +
                ", numberOfNods=" + numberOfNods +
                ", nodeNames=" + nodeNames +
                '}';
    }
}

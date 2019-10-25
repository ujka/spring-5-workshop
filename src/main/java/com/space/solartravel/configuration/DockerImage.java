package com.space.solartravel.configuration;

public class DockerImage {

    private String namePrefix;
    private String maxImageSize;

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getMaxImageSize() {
        return maxImageSize;
    }

    public void setMaxImageSize(String maxImageSize) {
        this.maxImageSize = maxImageSize;
    }

    @Override
    public String toString() {
        return "DockerImage{" +
                "namePrefix='" + namePrefix + '\'' +
                ", maxImageSize='" + maxImageSize + '\'' +
                '}';
    }
}

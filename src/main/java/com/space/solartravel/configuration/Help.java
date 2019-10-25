package com.space.solartravel.configuration;

public class Help {

    private String hierarchyLink;
    private String baeludngConfigProperties;

    public String getHierarchyLink() {
        return hierarchyLink;
    }

    public void setHierarchyLink(String hierarchyLink) {
        this.hierarchyLink = hierarchyLink;
    }

    public String getBaeludngConfigProperties() {
        return baeludngConfigProperties;
    }

    public void setBaeludngConfigProperties(String baeludngConfigProperties) {
        this.baeludngConfigProperties = baeludngConfigProperties;
    }

    @Override
    public String toString() {
        return "Help{" +
                "hierarchyLink='" + hierarchyLink + '\'' +
                ", baeludngConfigProperties='" + baeludngConfigProperties + '\'' +
                '}';
    }
}

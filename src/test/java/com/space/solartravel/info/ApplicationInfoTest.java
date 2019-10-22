package com.space.solartravel.info;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationInfoTest {

    private ApplicationInfo testee;

    @Test
    void toString_allPropertiesDefined_printsAll() {
        testee = new ApplicationInfo(new SpringCreator());
        testee.setSystemType(new SystemType());
        String expectedResult = "ApplicationInfo{version=0.0.1, systemType=demo, springCreator=Rod Johnson}";
        assertEquals(expectedResult, testee.toString());
    }

    @Test
    void toString_systemTypeNotSet_printsAllExpectSystemType() {
        testee = new ApplicationInfo(new SpringCreator());
        String expectedResult = "ApplicationInfo{version=0.0.1, systemType=null, springCreator=Rod Johnson}";
        assertEquals(expectedResult, testee.toString());
    }
}
package com.space.solartravel.info;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = InfoTestConfiguration.class)
class ApplicationInfoTest {

    @Autowired
    private ApplicationInfo testee;

    @Test
    void toString_allPropertiesDefined_printsAll() {
        testee.setSystemType(new SystemType());
        String expectedResult = "ApplicationInfo{version=0.0.1, systemType=demo, springCreator=Rod Johnson}";
        assertEquals(expectedResult, testee.toString());
    }

    @Test
    void toString_systemTypeNotSet_printsAllExpectSystemType() {
        String expectedResult = "ApplicationInfo{version=0.0.1, systemType=null, springCreator=Rod Johnson}";
        assertEquals(expectedResult, testee.toString());
    }
}
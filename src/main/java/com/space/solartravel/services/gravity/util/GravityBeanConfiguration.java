package com.space.solartravel.services.gravity.util;

import com.space.solartravel.services.gravity.GravityServiceImpl;
import com.space.solartravel.services.gravity.JupiterGravityServiceImpl;
import com.space.solartravel.services.gravity.MarsGravityServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GravityBeanConfiguration {

    @Bean
    public MarsGravityServiceImpl marsGravityService() {
        return new MarsGravityServiceImpl();
    }

    @Bean
    public JupiterGravityServiceImpl jupiterGravityService() {
        return new JupiterGravityServiceImpl();
    }

    @Bean
    public GravityServiceImpl saturnGravityService() {
        return new GravityServiceImpl(0.93);
    }

    @Bean
    public GravityServiceImpl uranusGravityService() {
        return new GravityServiceImpl(0.92);
    }

    @Bean
    public GravityServiceImpl neptuneGravityService() {
        return new GravityServiceImpl(1.12);
    }
}

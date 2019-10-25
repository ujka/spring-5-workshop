package com.space.solartravel.services.gravity.util;

import com.space.solartravel.services.gravity.GravityServiceImpl;
import com.space.solartravel.services.gravity.JupiterGravityServiceImpl;
import com.space.solartravel.services.gravity.MarsGravityServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:gravity.properties")
public class GravityBeanConfiguration {

    @Value("${gravity.surface_gravity.saturn}")
    private double saturnSurfaceGravity;

    @Value("${gravity.surface_gravity.uranus}")
    private double uranusSurfaceGravity;

    @Value("${gravity.surface_gravity.neptune}")
    private double neptuneSurfaceGravity;

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
        return new GravityServiceImpl(saturnSurfaceGravity);
    }

    @Bean
    public GravityServiceImpl uranusGravityService() {
        return new GravityServiceImpl(uranusSurfaceGravity);
    }

    @Bean
    public GravityServiceImpl neptuneGravityService() {
        return new GravityServiceImpl(neptuneSurfaceGravity);
    }
}

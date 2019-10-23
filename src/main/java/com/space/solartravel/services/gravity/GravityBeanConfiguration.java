package com.space.solartravel.services.gravity;

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

}

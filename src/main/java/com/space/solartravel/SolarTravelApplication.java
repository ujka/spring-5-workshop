package com.space.solartravel;

import com.space.solartravel.configuration.SpaceDeploymentConfiguration;
import com.space.solartravel.configuration.SpaceSecurityConfiguration;
import com.space.solartravel.configuration.SpaceSystemConfiguration;
import com.space.solartravel.info.ApplicationInfo;
import com.space.solartravel.info.SystemType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties
@Slf4j
public class SolarTravelApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SolarTravelApplication.class, args);

		//Bean loading
		ApplicationInfo applicationInfo = context.getBean(ApplicationInfo.class);
		applicationInfo.setSystemType(new SystemType());

		//Reading environment variable
		log.info(applicationInfo.toString());
		log.info("JAVA HOME: " + applicationInfo.getJavaHome());

		//Usage of @ConfigurationProperties
		SpaceSystemConfiguration spaceSystemConfiguration = context.getBean(SpaceSystemConfiguration.class);
		log.info(spaceSystemConfiguration.toString());

		SpaceDeploymentConfiguration spaceDeploymentConfiguration = context.getBean(SpaceDeploymentConfiguration.class);
		log.info(spaceDeploymentConfiguration.toString());

		SpaceSecurityConfiguration spaceSecurityConfiguration = context.getBean(SpaceSecurityConfiguration.class);
		log.info(spaceSecurityConfiguration.toString());
	}

}

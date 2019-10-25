package com.space.solartravel;

import com.space.solartravel.configuration.SpaceDeploymentConfiguration;
import com.space.solartravel.configuration.SpaceSystemConfiguration;
import com.space.solartravel.info.ApplicationInfo;
import com.space.solartravel.info.SystemType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties
public class SolarTravelApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SolarTravelApplication.class, args);

		//Bean loading
		ApplicationInfo applicationInfo = context.getBean(ApplicationInfo.class);
		applicationInfo.setSystemType(new SystemType());

		//Reading environment variable
		System.out.println(applicationInfo);
		System.out.println("JAVA HOME: " + applicationInfo.getJavaHome());

		//Usage of @ConfigurationProperties
		SpaceSystemConfiguration spaceSystemConfiguration = context.getBean(SpaceSystemConfiguration.class);
		System.out.println(spaceSystemConfiguration);

		SpaceDeploymentConfiguration spaceDeploymentConfiguration = context.getBean(SpaceDeploymentConfiguration.class);
		System.out.println(spaceDeploymentConfiguration);
	}

}

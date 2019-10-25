package com.space.solartravel;

import com.space.solartravel.info.ApplicationInfo;
import com.space.solartravel.info.SpringCreator;
import com.space.solartravel.info.SystemType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SolarTravelApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SolarTravelApplication.class, args);
		ApplicationInfo applicationInfo = context.getBean(ApplicationInfo.class);
		applicationInfo.setSystemType(new SystemType());
		System.out.println(applicationInfo);
		System.out.println("JAVA HOME: " + applicationInfo.getJavaHome());
	}

}

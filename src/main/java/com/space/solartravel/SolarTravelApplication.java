package com.space.solartravel;

import com.space.solartravel.info.ApplicationInfo;
import com.space.solartravel.info.SpringCreator;
import com.space.solartravel.info.SystemType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolarTravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolarTravelApplication.class, args);
		ApplicationInfo applicationInfo = new ApplicationInfo(new SpringCreator());
		applicationInfo.setSystemType(new SystemType());
		System.out.println(applicationInfo);
	}

}

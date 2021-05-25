package org.scheduling.demo;

import org.community.scheduler.config.GenericSchedulerAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author tudor.codrea
 *
 */
@SpringBootApplication
@ImportAutoConfiguration({ GenericSchedulerAutoConfiguration.class })
@EnableSwagger2
@EnableScheduling
@EnableCaching
public class SchedulingServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulingServiceDemoApplication.class, args);
	}
}

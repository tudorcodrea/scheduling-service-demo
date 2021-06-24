package org.scheduling.demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = {"org.scheduling.demo"})
public class GenericSchedulerConfig {

}

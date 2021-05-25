package org.scheduling.demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories({"org.community.scheduler.repository.api", "org.scheduling.demo.repository"})
@EntityScan(basePackages = { "org.community.scheduler.*", "org.scheduling.demo.*" })
@ComponentScan(basePackages = { "org.community.scheduler.*", "org.scheduling.demo.*" })
public class GenericSchedulerConfig {

}

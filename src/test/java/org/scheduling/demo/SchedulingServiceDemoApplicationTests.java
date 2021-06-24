package org.scheduling.demo;

import org.community.scheduler.GenericSchedulerAutoConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ImportAutoConfiguration(GenericSchedulerAutoConfiguration.class)
public class SchedulingServiceDemoApplicationTests {
	@Test
	public void contextLoads() {
	}
}

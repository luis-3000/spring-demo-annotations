package com.joselcastillo.springdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration /* This tells Spring that this is a Java configuration file and that it should follow
the appropriate rules in this configuration file */
@ComponentScan("com.joselcastillo.springdemo") /* Parameter should be the name of the package that we want
Spring to start scanning */
public class SportConfig {
	
}

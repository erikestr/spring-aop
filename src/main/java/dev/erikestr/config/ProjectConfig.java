package dev.erikestr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "dev.erikestr.beans", "dev.erikestr.services" })
public class ProjectConfig {

}

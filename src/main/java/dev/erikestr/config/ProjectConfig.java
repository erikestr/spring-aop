package dev.erikestr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "dev.erikestr.beans", "dev.erikestr.services", "dev.erikestr.aspects" })
@EnableAspectJAutoProxy
public class ProjectConfig {

}

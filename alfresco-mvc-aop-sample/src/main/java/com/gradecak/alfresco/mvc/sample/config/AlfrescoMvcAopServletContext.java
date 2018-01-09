package com.gradecak.alfresco.mvc.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.gradecak.alfresco.mvc.annotation.EnableAlfrescoMvcProxy;
import com.gradecak.alfresco.mvc.config.AlfrescoMvcServletContextConfig;
import com.gradecak.alfresco.mvc.sample.controller.AlfrescoMvcAopController;

@Configuration
@ComponentScan(basePackageClasses = { AlfrescoMvcAopController.class })
@EnableWebMvc
@EnableAlfrescoMvcProxy(basePackageClasses = AlfrescoMvcAopController.class)
public class AlfrescoMvcAopServletContext extends AlfrescoMvcServletContextConfig {

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
    final PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
    configurer.setIgnoreResourceNotFound(true);
    return configurer;
  }
}

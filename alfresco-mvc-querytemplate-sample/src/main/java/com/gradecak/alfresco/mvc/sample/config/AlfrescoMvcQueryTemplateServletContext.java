package com.gradecak.alfresco.mvc.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.gradecak.alfresco.mvc.rest.annotation.EnableAlfrescoMvcServlet;
import com.gradecak.alfresco.mvc.sample.controller.AlfrescoMvcQueryTemplateController;

@Configuration
@ComponentScan(basePackageClasses = { AlfrescoMvcQueryTemplateController.class })
@EnableAlfrescoMvcServlet
// use @EnableWebMvc if the default config should not be used
public class AlfrescoMvcQueryTemplateServletContext {

  @Bean
  public String aa() {
    return "AAA";
  }
}

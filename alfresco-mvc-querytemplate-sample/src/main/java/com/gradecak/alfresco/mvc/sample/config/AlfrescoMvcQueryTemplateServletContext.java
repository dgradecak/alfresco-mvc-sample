package com.gradecak.alfresco.mvc.sample.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.gradecak.alfresco.mvc.annotation.EnableAlfrescoMvcProxy;
import com.gradecak.alfresco.mvc.config.AlfrescoMvcServletContextConfig;
import com.gradecak.alfresco.mvc.sample.controller.AlfrescoMvcQueryTemplateController;
import com.gradecak.alfresco.mvc.sample.service.QueryTemplateService;

@Configuration
@ComponentScan(basePackageClasses = { AlfrescoMvcQueryTemplateController.class })
@EnableWebMvc
@EnableAlfrescoMvcProxy(basePackageClasses = AlfrescoMvcQueryTemplateController.class)
public class AlfrescoMvcQueryTemplateServletContext extends AlfrescoMvcServletContextConfig {
  
  
  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
    final PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
    configurer.setIgnoreResourceNotFound(true);
    return configurer;
  }
}

package com.gradecak.alfresco.mvc.sample.config;

import org.alfresco.repo.model.Repository;
import org.alfresco.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.gradecak.alfresco.mvc.config.AlfrescoMvcRestConfig;
import com.gradecak.alfresco.mvc.sample.service.QueryTemplateService;

@Configuration
public class AlfrescoMvcQueryTemplateModuleConfig extends AlfrescoMvcRestConfig {

  @Override
  protected Class<? extends WebMvcConfigurerAdapter> configureWebMvcConfigurerAdapter() {
    return AlfrescoMvcQueryTemplateServletContext.class;
  }

  @Bean
  public QueryTemplateService queryTemplateService(ServiceRegistry serviceRegistry, Repository repository) {
    return new QueryTemplateService(serviceRegistry, repository);
  }
}

package com.gradecak.alfresco.mvc.sample.config;

import org.alfresco.repo.model.Repository;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.gradecak.alfresco.mvc.config.AlfrescoMvcRestConfig;
import com.gradecak.alfresco.mvc.sample.service.AopService;
import com.gradecak.alfresco.mvc.webscript.DispatcherWebscript;

@Configuration
public class AlfrescoMvcAopModuleConfig extends AlfrescoMvcRestConfig {

  @Override
  protected Class<AlfrescoMvcAopServletContext> configureWebMvcConfigurerAdapter() {
    return AlfrescoMvcAopServletContext.class;
  }

  @Bean
  public AopService aopService(Repository repository) {
    return new AopService(repository);
  }
}

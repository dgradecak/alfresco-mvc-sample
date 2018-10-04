package com.gradecak.alfresco.mvc.sample.config;

import org.springframework.context.annotation.Configuration;

import com.gradecak.alfresco.mvc.rest.config.AlfrescoMvcRestConfig;

@Configuration
public class AlfrescoMvcRestModuleConfig extends AlfrescoMvcRestConfig {

  @Override
  protected Class<AlfrescoMvcRestServletContext> servletContext() {
    return AlfrescoMvcRestServletContext.class;
  }
}

package com.gradecak.alfresco.mvc.sample.config;

import org.alfresco.service.cmr.repository.NodeRef;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gradecak.alfresco.mvc.annotation.EnableAlfrescoMvcAop;
import com.gradecak.alfresco.mvc.rest.converter.NodeRefConverter;
import com.gradecak.alfresco.mvc.sample.controller.AlfrescoMvcAopController;

@Configuration
@ComponentScan(basePackageClasses = { AlfrescoMvcAopController.class })
@EnableWebMvc
@EnableAlfrescoMvcAop(basePackageClasses = AlfrescoMvcAopController.class)
public class AlfrescoMvcAopServletContext implements WebMvcConfigurer {

	  @Override
	  public void addFormatters(FormatterRegistry formatterRegistry) {
	    formatterRegistry.addConverter((Converter<String, NodeRef>) new NodeRefConverter());
	  }
}

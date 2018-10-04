package com.gradecak.alfresco.mvc.sample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.gradecak.alfresco.mvc.annotation.EnableAlfrescoMvcAop;
import com.gradecak.alfresco.mvc.rest.config.AlfrescoMvcServletContextConfig;
import com.gradecak.alfresco.mvc.sample.controller.AlfrescoMvcAopController;

@Configuration
@ComponentScan(basePackageClasses = { AlfrescoMvcAopController.class })
@EnableWebMvc
@EnableAlfrescoMvcAop(basePackageClasses = AlfrescoMvcAopController.class)
public class AlfrescoMvcAopServletContext extends AlfrescoMvcServletContextConfig {

}

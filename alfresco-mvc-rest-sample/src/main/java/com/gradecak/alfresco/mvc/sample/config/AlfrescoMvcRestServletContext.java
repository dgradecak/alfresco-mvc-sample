package com.gradecak.alfresco.mvc.sample.config;

import java.util.List;

import org.alfresco.repo.model.Repository;
import org.alfresco.rest.api.Nodes;
import org.alfresco.rest.framework.webscripts.ResourceWebScriptHelper;
import org.alfresco.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gradecak.alfresco.mvc.rest.AlfrescoApiResponseInterceptor;
import com.gradecak.alfresco.mvc.rest.annotation.EnableAlfrescoMvcWeb;
import com.gradecak.alfresco.mvc.rest.config.ParamsHandlerMethodArgumentResolver;
import com.gradecak.alfresco.mvc.sample.controller.AlfrescoMvcRestController;
import com.gradecak.alfresco.mvc.sample.service.SampleService;

@Configuration
@EnableAlfrescoMvcWeb
@ComponentScan(basePackageClasses = { AlfrescoMvcRestController.class })
public class AlfrescoMvcRestServletContext implements WebMvcConfigurer {

	@Bean
	public SampleService sampleService(Repository repository, Nodes nodes) {
		return new SampleService(repository, nodes);
	}
}

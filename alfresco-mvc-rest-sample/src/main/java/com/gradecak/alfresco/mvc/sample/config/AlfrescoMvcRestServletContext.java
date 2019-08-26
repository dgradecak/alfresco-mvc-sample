package com.gradecak.alfresco.mvc.sample.config;

import org.alfresco.repo.model.Repository;
import org.alfresco.rest.api.Nodes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gradecak.alfresco.mvc.rest.annotation.EnableWebAlfrescoMvc;
import com.gradecak.alfresco.mvc.sample.controller.AlfrescoMvcRestController;
import com.gradecak.alfresco.mvc.sample.service.SampleService;

@Configuration
@EnableWebAlfrescoMvc
@ComponentScan(basePackageClasses = { AlfrescoMvcRestController.class })
public class AlfrescoMvcRestServletContext implements WebMvcConfigurer {

	@Bean
	public SampleService sampleService(Repository repository, Nodes nodes) {
		return new SampleService(repository, nodes);
	}
}

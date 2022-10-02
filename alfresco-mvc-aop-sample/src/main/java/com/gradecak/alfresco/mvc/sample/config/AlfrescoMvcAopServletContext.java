package com.gradecak.alfresco.mvc.sample.config;

import org.alfresco.repo.model.Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.gradecak.alfresco.mvc.annotation.EnableAlfrescoMvcAop;
import com.gradecak.alfresco.mvc.sample.controller.AlfrescoMvcAopController;
import com.gradecak.alfresco.mvc.sample.service.AopService;

@Configuration
@EnableWebMvc
@EnableAlfrescoMvcAop(basePackageClasses = { AopService.class })
public class AlfrescoMvcAopServletContext {

	@Bean
	AlfrescoMvcAopController alfrescoMvcAopController() {
		return new AlfrescoMvcAopController();
	}

	@Bean
	public AopService aopService(Repository repository) {
		return new AopService(repository);
	}
}

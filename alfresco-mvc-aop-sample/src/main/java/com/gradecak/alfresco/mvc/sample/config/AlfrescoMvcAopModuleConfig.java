package com.gradecak.alfresco.mvc.sample.config;

import org.alfresco.repo.model.Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gradecak.alfresco.mvc.rest.annotation.AlfrescoDispatcherWebscript;
import com.gradecak.alfresco.mvc.rest.annotation.EnableAlfrescoMvcRest;
import com.gradecak.alfresco.mvc.sample.service.AopService;

@Configuration
@EnableAlfrescoMvcRest(@AlfrescoDispatcherWebscript(servletContext = AlfrescoMvcAopServletContext.class))
public class AlfrescoMvcAopModuleConfig {

	@Bean
	public AopService aopService(Repository repository) {
		return new AopService(repository);
	}
}

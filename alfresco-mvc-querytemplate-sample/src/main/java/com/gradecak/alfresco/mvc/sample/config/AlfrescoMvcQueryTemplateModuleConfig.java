package com.gradecak.alfresco.mvc.sample.config;

import org.alfresco.repo.model.Repository;
import org.alfresco.rest.api.Nodes;
import org.alfresco.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gradecak.alfresco.mvc.annotation.EnableAlfrescoMvcAop;
import com.gradecak.alfresco.mvc.rest.annotation.AlfrescoDispatcherWebscript;
import com.gradecak.alfresco.mvc.rest.annotation.EnableAlfrescoMvcRest;
import com.gradecak.alfresco.mvc.sample.service.QueryTemplateService;

@Configuration
@EnableAlfrescoMvcAop(basePackageClasses = QueryTemplateService.class)
@EnableAlfrescoMvcRest({ @AlfrescoDispatcherWebscript(servletContext = AlfrescoMvcQueryTemplateServletContext.class) })
public class AlfrescoMvcQueryTemplateModuleConfig {

	@Bean
	public QueryTemplateService queryTemplateService(ServiceRegistry serviceRegistry, Repository repository,
			Nodes nodes) {
		return new QueryTemplateService(serviceRegistry, repository, nodes);
	}
}

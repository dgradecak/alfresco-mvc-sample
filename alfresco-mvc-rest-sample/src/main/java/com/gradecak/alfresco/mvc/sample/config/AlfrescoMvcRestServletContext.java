package com.gradecak.alfresco.mvc.sample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gradecak.alfresco.mvc.rest.annotation.EnableWebAlfrescoMvc;
import com.gradecak.alfresco.mvc.sample.controller.AlfrescoMvcRestController;

@Configuration
@EnableWebAlfrescoMvc
@ComponentScan(basePackageClasses = { AlfrescoMvcRestController.class })
public class AlfrescoMvcRestServletContext implements WebMvcConfigurer {
}
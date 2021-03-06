package com.gradecak.alfresco.mvc.sample.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gradecak.alfresco.mvc.annotation.AlfrescoTransaction;
import com.gradecak.alfresco.mvc.rest.ResponseMapBuilder;
import com.gradecak.alfresco.mvc.sample.service.AopService;

/**
 * shows how to use the Alfresco @MVC framework
 */

@Controller
@RequestMapping("/aop")
public class AlfrescoMvcAopController {

	@Autowired
	private AopService service;

	@AlfrescoTransaction(readOnly = true)
	@RequestMapping(value = "sample", method = { RequestMethod.GET })
	public ResponseEntity<?> sample() throws IOException {
		return new ResponseEntity<>(new ResponseMapBuilder()
				.withEntry("this is the company root noderef json representation", service.findRootNodeRef()).build(),
				HttpStatus.OK);
	}
}

package com.gradecak.alfresco.mvc.sample.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gradecak.alfresco.mvc.sample.service.AopService;

/**
 * shows how to use the Alfresco @MVC framework
 */

@RestController
@RequestMapping("/aop")
public class AlfrescoMvcAopController {

	@Autowired
	private AopService service;

	@RequestMapping(value = "sample", method = { RequestMethod.GET })
	public ResponseEntity<?> sample() throws IOException {
		return new ResponseEntity<>(
				Map.of("this is the company root noderef json representation", service.findRootNodeRef()),
				HttpStatus.OK);
	}
}

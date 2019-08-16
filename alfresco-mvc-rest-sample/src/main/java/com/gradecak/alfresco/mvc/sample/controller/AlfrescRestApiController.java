package com.gradecak.alfresco.mvc.sample.controller;

import java.io.IOException;
import java.util.Map;

import org.alfresco.rest.api.model.Node;
import org.alfresco.rest.framework.resource.parameters.CollectionWithPagingInfo;
import org.alfresco.rest.framework.resource.parameters.Params;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.namespace.QName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableMap;
import com.gradecak.alfresco.mvc.rest.AlfrescoResponseEntity;
import com.gradecak.alfresco.mvc.sample.service.SampleService;

/**
 * shows how to use the Alfresco @MVC framework
 */

@RestController
@RequestMapping("/restapi")
public class AlfrescRestApiController {
	
	private final SampleService sampleService;
	
	@Autowired
    public AlfrescRestApiController(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	@GetMapping(value = "sample")
	public ResponseEntity<?> sample() throws IOException {
		return new AlfrescoResponseEntity<>("Alfresco @MVC REST sample", HttpStatus.OK);
	}
	
	@GetMapping(value = "json")
	public ResponseEntity<?> json() throws IOException {
		return new AlfrescoResponseEntity<>(ImmutableMap.of("key1", "value1"), HttpStatus.OK);
	}

	@GetMapping(value = "qname")
	public ResponseEntity<?> qname() throws IOException {
		return new AlfrescoResponseEntity<>(QName.createQName("{aaa}aaa"), HttpStatus.OK);
	}

	@PostMapping(value = "sample")
	public ResponseEntity<?> sample(@RequestBody final Map<String, String> body) throws IOException {
		return new AlfrescoResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "noderef")
	public ResponseEntity<?> noderef(@RequestParam NodeRef nodeRef) {
		return new AlfrescoResponseEntity<>(nodeRef, HttpStatus.OK);
	}
	
	@GetMapping(value = "query")
	public ResponseEntity<?> query(Params params)  {
		CollectionWithPagingInfo<Node> rootNodes = sampleService.rootNodes(params);
		return new AlfrescoResponseEntity<>(rootNodes, HttpStatus.OK);
	}
	
	@ExceptionHandler({ IOException.class })
	public ResponseEntity<?> handleIOException(IOException exc) {
		exc.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("error", "internal server error").build();
	}
}

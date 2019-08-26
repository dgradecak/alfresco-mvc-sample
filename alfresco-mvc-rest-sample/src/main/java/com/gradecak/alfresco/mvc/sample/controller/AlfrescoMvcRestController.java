package com.gradecak.alfresco.mvc.sample.controller;

import java.io.IOException;
import java.util.Map;

import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.namespace.QName;
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
import com.gradecak.alfresco.mvc.rest.annotation.AlfrescoRestResponse;

/**
 * shows how to use the Alfresco @MVC framework
 */

@RestController
@RequestMapping("/rest")
public class AlfrescoMvcRestController {

	@GetMapping(value = "sample")
	public ResponseEntity<?> sample() throws IOException {
		return ResponseEntity.ok("Alfresco @MVC REST sample");
	}

	@GetMapping(value = "json")
	public ResponseEntity<?> json() throws IOException {
		return ResponseEntity.ok(ImmutableMap.of("key1", "value1"));
	}

	@GetMapping(value = "qname")
	public ResponseEntity<?> qname() throws IOException {
		return ResponseEntity.ok(QName.createQName("{aaa}aaa"));
	}

	@GetMapping(value = "download")
	public ResponseEntity<?> download() throws IOException {
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"module.properties\"")
				.body(new ClassPathResource("alfresco/module/alfresco-mvc-rest-sample/module.properties"));
	}

	@PostMapping(value = "sample")
	public ResponseEntity<?> sample(@RequestBody final Map<String, String> body) throws IOException {
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "noderef")
	public ResponseEntity<?> noderef(@RequestParam NodeRef nodeRef) throws IOException {
		return ResponseEntity.ok(nodeRef);
	}

	@AlfrescoRestResponse
	@GetMapping(value = "noderefAlfresco")
	public ResponseEntity<?> noderefAlfresco(@RequestParam NodeRef nodeRef) throws IOException {
		return ResponseEntity.ok(nodeRef);
	}

	@GetMapping(value = "exception")
	public ResponseEntity<?> exception() throws IOException {
		throw new RuntimeException();
	}

	@ExceptionHandler({ RuntimeException.class })
	public ResponseEntity<?> handleRuntimeException(RuntimeException exc) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("error", "internal server error").build();
	}
}

package com.gradecak.alfresco.mvc.sample.controller;

import java.io.IOException;

import org.alfresco.rest.framework.resource.parameters.CollectionWithPagingInfo;
import org.alfresco.rest.framework.resource.parameters.Paging;
import org.alfresco.rest.framework.resource.parameters.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gradecak.alfresco.mvc.annotation.AlfrescoTransaction;
import com.gradecak.alfresco.mvc.rest.annotation.AlfrescoRestResponse;
import com.gradecak.alfresco.mvc.sample.domain.CmFolder;
import com.gradecak.alfresco.mvc.sample.service.QueryTemplateService;

/**
 * shows how to use the Alfresco @MVC framework
 */

@Controller
@RequestMapping("/querytemplate")
@AlfrescoRestResponse
public class AlfrescoMvcQueryTemplateController {

	@Autowired
	private QueryTemplateService service;

	@AlfrescoTransaction(readOnly = true)
	@RequestMapping(value = "sample", method = { RequestMethod.GET })
	public ResponseEntity<?> sample() throws IOException {
		return ResponseEntity.ok(service.getCompanyHomeFolder());
	}

	@AlfrescoTransaction(readOnly = true)
	@RequestMapping(value = "search", method = { RequestMethod.GET })
	public ResponseEntity<?> search() {
		CollectionWithPagingInfo<CmFolder> collection = CollectionWithPagingInfo.asPaged(Paging.DEFAULT,
				service.search());
		return ResponseEntity.ok(collection);
	}

	@AlfrescoTransaction(readOnly = true)
	@RequestMapping(value = "nodes", method = { RequestMethod.GET })
	public ResponseEntity<?> nodes(Params params) throws IOException {
		return ResponseEntity.ok(service.rootNodes(params));
	}

	@AlfrescoTransaction(readOnly = true)
	@RequestMapping(value = "node", method = { RequestMethod.GET })
	public ResponseEntity<?> node() throws IOException {
		return ResponseEntity.ok(service.findRootNode());
	}
}

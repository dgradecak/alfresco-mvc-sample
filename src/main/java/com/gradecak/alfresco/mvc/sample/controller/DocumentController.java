package com.gradecak.alfresco.mvc.sample.controller;

import java.io.IOException;
import java.util.Map;

import org.alfresco.service.cmr.repository.NodeRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gradecak.alfresco.mvc.JsonUtils;
import com.gradecak.alfresco.mvc.sample.domain.Document;
import com.gradecak.alfresco.mvc.sample.service.DocumentService;

/**
 * shows how to use the Alfresco @MVC framework
 */

@Controller
@RequestMapping("/document/**")
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	@RequestMapping(value = "sample", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> sample(@RequestBody final Document docCreated) throws IOException {
		
		// for this show case purposes we call create which is marked as AlfrescoTransaction
		NodeRef createdRef = documentService.create(docCreated);

		// in a second transaction we do the update
		Document document = documentService.get(createdRef);
		document.setDescription(document.getDescription() + " updated!");
		documentService.update(createdRef, document);

		// ... yet another transaction
		return JsonUtils.createResponseMap(documentService.get(createdRef), true);
	}
	
	@RequestMapping(value = "findAll", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> findAll() throws IOException {
		return JsonUtils.createResponseMap(documentService.findAll(), true);
	}

}

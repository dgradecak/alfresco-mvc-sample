package com.gradecak.alfresco.mvc.sample.controller;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.alfresco.service.cmr.repository.NodeRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gradecak.alfresco.mvc.sample.domain.CustomDocument;
import com.gradecak.alfresco.mvc.sample.service.CustomDocumentService;
import com.gradecak.alfresco.simpless.JsonUtils;
import com.gradecak.alfresco.simpless.Metadata;

/**
 * shows how to use the Alfresco @MVC framework
 */

@Controller
@RequestMapping("/sample/**")
public class CustomDocumentController {

	@Autowired
	private CustomDocumentService documentService;

	@RequestMapping(value = "index", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> index(final String content) throws IOException {

		// for show case purposes we call create which is marked as AlfrescoTransaction
		NodeRef createdRef = documentService.create(new Metadata());

		// in a second transaction we do the update
		CustomDocument document = new CustomDocument(createdRef);
		document.setName(UUID.randomUUID().toString() + ".txt");
		documentService.update(document);

		// ... yet another transaction, as describe by the service annotations
		return JsonUtils.createResponseMap(documentService.get(document.getNodeRef()), true);
	}

}

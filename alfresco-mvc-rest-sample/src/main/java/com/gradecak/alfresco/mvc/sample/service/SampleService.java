package com.gradecak.alfresco.mvc.sample.service;

import org.alfresco.repo.model.Repository;
import org.alfresco.rest.api.Nodes;
import org.alfresco.rest.api.model.Node;
import org.alfresco.rest.framework.resource.parameters.CollectionWithPagingInfo;
import org.alfresco.rest.framework.resource.parameters.Params;
import org.alfresco.service.cmr.repository.NodeRef;

import com.gradecak.alfresco.mvc.rest.AlfrescoApiResponseInterceptor;

public class SampleService {
	private final Repository repository;
	private final Nodes nodes;

	public SampleService(Repository repository, Nodes nodes) {
		this.repository = repository;
		this.nodes = nodes;
	}

	public NodeRef findRootNodeRef() {
		return repository.getCompanyHome();
	}

	public CollectionWithPagingInfo<Node> rootNodes(Params params) {
		CollectionWithPagingInfo<Node> listChildren = nodes.listChildren(findRootNodeRef().getId(), params);
		return listChildren;
	}

	public Node findRootNode() {
		Node node = nodes.getFolderOrDocument(repository.getCompanyHome().getId(),
				AlfrescoApiResponseInterceptor.getDefaultParameters(null));
		return node;
	}
}

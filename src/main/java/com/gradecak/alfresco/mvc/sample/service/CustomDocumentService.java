package com.gradecak.alfresco.mvc.sample.service;

import java.io.Serializable;
import java.util.Map;

import org.alfresco.model.ContentModel;
import org.alfresco.repo.model.Repository;
import org.alfresco.service.ServiceRegistry;
import org.alfresco.service.cmr.repository.ChildAssociationRef;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.namespace.QName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gradecak.alfresco.mvc.annotation.AlfrescoTransaction;
import com.gradecak.alfresco.mvc.sample.domain.CustomDocument;
import com.gradecak.alfresco.simpless.MetadataManager;

@Service
public class CustomDocumentService {

	@Autowired
	private ServiceRegistry serviceRegistry;

	@Autowired
	private MetadataManager metadataManager;

	@Autowired
	private Repository repository;

	@AlfrescoTransaction
	public NodeRef create(final Map<QName, Serializable> metadata) {
		ChildAssociationRef nodeAssoc = serviceRegistry.getNodeService().createNode(repository.getCompanyHome(), ContentModel.ASSOC_CONTAINS,
		    ContentModel.ASSOC_CONTAINS, ContentModel.TYPE_CONTENT, metadata);

		return nodeAssoc.getChildRef();
	}

	@AlfrescoTransaction
	public CustomDocument update(final CustomDocument document) {
		document.setDescription("custom description from java service");
		return metadataManager.save(document);
	}

	@AlfrescoTransaction(readOnly = true)
	public CustomDocument get(final NodeRef ref) {
		CustomDocument document = new CustomDocument();
		document.setNodeRef(ref);
		return metadataManager.get(document);
	}

}

package com.gradecak.alfresco.mvc.sample.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.alfresco.model.ContentModel;
import org.alfresco.repo.model.Repository;
import org.alfresco.service.ServiceRegistry;
import org.alfresco.service.cmr.repository.ChildAssociationRef;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.namespace.QName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gradecak.alfresco.querytemplate.QueryBuilder;
import com.gradecak.alfresco.querytemplate.QueryTemplate;
import com.gradecak.alfresco.mvc.annotation.AlfrescoTransaction;
import com.gradecak.alfresco.mvc.sample.domain.Document;
import com.gradecak.alfresco.mvc.sample.mapper.DocumentNodeMapper;

@Service
public class DocumentService {

	@Autowired
	private ServiceRegistry serviceRegistry;

	@Autowired
	private Repository repository;
	
	@AlfrescoTransaction
	public NodeRef create(Document document) {
		Map<QName, Serializable> properties = DocumentNodeMapper.mapBean(document);
		
		ChildAssociationRef nodeAssoc = serviceRegistry.getNodeService().createNode(repository.getCompanyHome(), ContentModel.ASSOC_CONTAINS,
		    ContentModel.ASSOC_CONTAINS, ContentModel.TYPE_CONTENT, properties);

		return nodeAssoc.getChildRef();
	}
	
	@AlfrescoTransaction
	public void update(final NodeRef ref, final Document document) {
		Map<QName, Serializable> properties = DocumentNodeMapper.mapBean(document);
		serviceRegistry.getNodeService().setProperties(ref, properties);
	}
	
	@AlfrescoTransaction(readOnly = true)
	public Document get(final NodeRef ref) {
		return new QueryTemplate(serviceRegistry).queryForObject(ref, new DocumentNodeMapper());
	}
	
	@AlfrescoTransaction(readOnly = true)
	public List<Document> findAll() {
		return new QueryTemplate(serviceRegistry).queryForList(new QueryBuilder().type(ContentModel.TYPE_CONTENT), new DocumentNodeMapper());
	}

}

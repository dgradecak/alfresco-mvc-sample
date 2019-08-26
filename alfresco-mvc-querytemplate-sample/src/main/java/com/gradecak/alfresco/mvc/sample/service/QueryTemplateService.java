package com.gradecak.alfresco.mvc.sample.service;

import java.util.List;

import org.alfresco.model.ContentModel;
import org.alfresco.repo.model.Repository;
import org.alfresco.rest.api.Nodes;
import org.alfresco.rest.api.model.Node;
import org.alfresco.rest.framework.resource.parameters.CollectionWithPagingInfo;
import org.alfresco.rest.framework.resource.parameters.Params;
import org.alfresco.service.ServiceRegistry;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.StoreRef;
import org.alfresco.service.cmr.search.ResultSet;
import org.alfresco.service.cmr.search.SearchService;

import com.gradecak.alfresco.mvc.annotation.AlfrescoTransaction;
import com.gradecak.alfresco.mvc.rest.AlfrescoApiResponseInterceptor;
import com.gradecak.alfresco.mvc.sample.domain.CmFolder;
import com.gradecak.alfresco.mvc.sample.mapper.CmFolderPropertiesMapper;
import com.gradecak.alfresco.querytemplate.BeanPropertiesMapperRegistry;
import com.gradecak.alfresco.querytemplate.BeanPropertiesMapperUtil;
import com.gradecak.alfresco.querytemplate.QueryBuilder;

public class QueryTemplateService {

	private final ServiceRegistry serviceRegistry;
	private final Repository repository;
	private final BeanPropertiesMapperRegistry beanPropertiesMapperRegistry;
	private final BeanPropertiesMapperUtil beanPropertiesMapperUtil;
	private final Nodes nodes;

	public QueryTemplateService(ServiceRegistry serviceRegistry, Repository repository, Nodes nodes) {
		this.serviceRegistry = serviceRegistry;
		this.repository = repository;
		this.nodes = nodes;
		this.beanPropertiesMapperRegistry = new BeanPropertiesMapperRegistry(serviceRegistry.getNamespaceService(),
				serviceRegistry.getDictionaryService());
		this.beanPropertiesMapperRegistry.addBeanPropertiesMapper(new CmFolderPropertiesMapper(serviceRegistry));
		this.beanPropertiesMapperUtil = new BeanPropertiesMapperUtil(beanPropertiesMapperRegistry);
	}

	@AlfrescoTransaction(readOnly = true)
	public NodeRef findRootNodeRef() {
		return repository.getCompanyHome();
	}

	@AlfrescoTransaction(readOnly = true)
	public CmFolder getCompanyHomeFolder() {
		NodeRef findRootNodeRef = findRootNodeRef();
		// BeanPropertiesMapper<CmFolder> mapper =
		// beanPropertiesMapperRegistry.getForClass(CmFolder.class);
		// return mapper.mapNodeProperties(findRootNodeRef,
		// serviceRegistry.getNodeService().getProperties(findRootNodeRef));
		return beanPropertiesMapperUtil.mapProperties(findRootNodeRef,
				serviceRegistry.getNodeService().getProperties(findRootNodeRef), CmFolder.class);
	}

	@AlfrescoTransaction(readOnly = true)
	public List<CmFolder> search() {
		ResultSet resultSet = serviceRegistry.getSearchService().query(StoreRef.STORE_REF_WORKSPACE_SPACESSTORE,
				SearchService.LANGUAGE_LUCENE, new QueryBuilder().type(ContentModel.TYPE_CONTENT).build());
		return beanPropertiesMapperUtil.mapResultSet(resultSet, CmFolder.class);
	}

	@AlfrescoTransaction(readOnly = true)
	public CollectionWithPagingInfo<Node> rootNodes(Params params) {
		// ResultSet resultSet =
		// serviceRegistry.getSearchService().query(StoreRef.STORE_REF_WORKSPACE_SPACESSTORE,
		// SearchService.LANGUAGE_LUCENE, new
		// QueryBuilder().type(ContentModel.TYPE_CONTENT).build());
		CollectionWithPagingInfo<Node> listChildren = nodes.listChildren(findRootNodeRef().getId(), params);
		return listChildren;
	}

	@AlfrescoTransaction(readOnly = true)
	public Node findRootNode() {
		Node node = nodes.getFolderOrDocument(repository.getCompanyHome().getId(),
				AlfrescoApiResponseInterceptor.getDefaultParameters(null));
		return node;
	}
}

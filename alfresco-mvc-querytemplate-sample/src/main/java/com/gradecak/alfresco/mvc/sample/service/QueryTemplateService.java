package com.gradecak.alfresco.mvc.sample.service;

import org.alfresco.model.ContentModel;
import org.alfresco.repo.model.Repository;
import org.alfresco.service.ServiceRegistry;
import org.alfresco.service.cmr.repository.NodeRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.gradecak.alfresco.mvc.annotation.AlfrescoTransaction;
import com.gradecak.alfresco.mvc.sample.domain.CmFolder;
import com.gradecak.alfresco.mvc.sample.mapper.CmFolderPropertiesMapper;
import com.gradecak.alfresco.querytemplate.QueryBuilder;
import com.gradecak.alfresco.querytemplate.QueryTemplate;

@Service
public class QueryTemplateService {

  private final ServiceRegistry serviceRegistry;

  private final Repository repository;
  
  public QueryTemplateService(ServiceRegistry serviceRegistry, Repository repository) {
    this.serviceRegistry = serviceRegistry;
    this.repository = repository;
  }

  @AlfrescoTransaction(readOnly = true)
  public NodeRef findRootNodeRef() {
    return repository.getCompanyHome();
  }

  public CmFolder getCompanyHomeFolder() {
    NodeRef findRootNodeRef = findRootNodeRef();
    return new QueryTemplate(serviceRegistry).queryForObject(findRootNodeRef, new CmFolderPropertiesMapper(serviceRegistry));
  }

  public Page<CmFolder> search() {
    return new QueryTemplate(serviceRegistry).queryForList(new QueryBuilder().type(ContentModel.TYPE_FOLDER), new CmFolderPropertiesMapper(serviceRegistry));
  }

}

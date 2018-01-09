package com.gradecak.alfresco.mvc.sample.service;

import org.alfresco.repo.model.Repository;
import org.alfresco.service.cmr.repository.NodeRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gradecak.alfresco.mvc.annotation.AlfrescoTransaction;

@Service
public class AopService {

  private final Repository repository;

  public AopService(Repository repository) {
    this.repository = repository;
  }

  public NodeRef findRootNodeRef() {
    return repository.getCompanyHome();
  }

}

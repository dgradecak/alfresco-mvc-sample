package com.gradecak.alfresco.mvc.sample.mapper;

import org.alfresco.service.ServiceRegistry;
import org.alfresco.service.cmr.repository.NodeRef;

import com.gradecak.alfresco.mvc.sample.domain.CmFolder;
import com.gradecak.alfresco.querytemplate.BeanPropertiesMapper;
import com.gradecak.alfresco.querytemplate.BeanPropertiesMapperConfigurer;

public class CmFolderPropertiesMapper extends BeanPropertiesMapper<CmFolder> implements BeanPropertiesMapperConfigurer<CmFolder> {

  public CmFolderPropertiesMapper(ServiceRegistry serviceRegistry) {
    super(serviceRegistry.getNamespaceService(), serviceRegistry.getDictionaryService(), false);
  }

  public void configure(NodeRef nodeRef, CmFolder mappedObject) {
    mappedObject.setRef(nodeRef.getId());
  }
}

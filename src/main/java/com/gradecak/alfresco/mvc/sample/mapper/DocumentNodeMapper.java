package com.gradecak.alfresco.mvc.sample.mapper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.alfresco.model.ContentModel;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.namespace.QName;

import com.gradecak.alfresco.mvc.mapper.NodePropertiesMapper;
import com.gradecak.alfresco.mvc.sample.domain.Document;

public class DocumentNodeMapper implements NodePropertiesMapper<Document> {

  public Document mapNodeProperties(NodeRef nodeRef, Map<QName, Serializable> properties) {
    Document dl = new Document();
    dl.setDescription((String) properties.get(ContentModel.PROP_DESCRIPTION));

    return dl;
  }

  // TODO this is a simple helper
  public static Map<QName, Serializable> mapBean(Document bean) {
    Map<QName, Serializable> map = new HashMap<QName, Serializable>();
    map.put(ContentModel.PROP_DESCRIPTION, bean.getDescription());
    return map;
  }
}

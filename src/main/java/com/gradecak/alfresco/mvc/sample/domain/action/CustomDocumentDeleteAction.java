package com.gradecak.alfresco.mvc.sample.domain.action;

import org.alfresco.service.ServiceRegistry;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.security.AccessStatus;
import org.alfresco.service.cmr.security.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import com.gradecak.alfresco.mvc.sample.domain.CustomDocument;
import com.gradecak.alfresco.simpless.Action;

public class CustomDocumentDeleteAction implements Action {

  @Autowired
  private ServiceRegistry serviceRegistry;

  private CustomDocument document;

  public CustomDocumentDeleteAction(final CustomDocument document) {
    this.document = document;
  }

  public String getName() {
    return "documentDelete";
  }

  public boolean isAllowed() {
    final NodeRef documentNodeRef = document.getNodeRef();
    final AccessStatus permission = serviceRegistry.getPermissionService().hasPermission(documentNodeRef, PermissionService.DELETE);
    boolean allowed = AccessStatus.ALLOWED.equals(permission);

    if (allowed) {
      // do your applicative checks if needed
    }

    return allowed;
  }
}

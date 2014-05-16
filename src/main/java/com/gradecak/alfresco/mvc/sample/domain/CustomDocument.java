package com.gradecak.alfresco.mvc.sample.domain;

import java.util.List;

import org.alfresco.model.ContentModel;
import org.alfresco.service.cmr.repository.NodeRef;

import com.gradecak.alfresco.mvc.sample.domain.action.CustomDocumentDeleteAction;
import com.gradecak.alfresco.simpless.Action;
import com.gradecak.alfresco.simpless.ActionHolder;
import com.gradecak.alfresco.simpless.ActionList;
import com.gradecak.alfresco.simpless.domain.CmContent;

@SuppressWarnings("serial")
public class CustomDocument extends CmContent implements ActionList {

	private ActionHolder actionHolder = new ActionHolder();

	public CustomDocument() {
		super();
		actionHolder.addAction(new CustomDocumentDeleteAction(this));
	}

	public CustomDocument(NodeRef ref) {
		this();
		this.setNodeRef(ref);
	}

	public List<Action> getActionList() {
		return actionHolder.getActionList();
	}

	public String getDescription() {
		return (String) holder.getProperty(ContentModel.PROP_DESCRIPTION);
	}

	public void setDescription(String description) {
		holder.setProperty(ContentModel.PROP_DESCRIPTION, description);
	}

}

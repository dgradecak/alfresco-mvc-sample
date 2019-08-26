package com.gradecak.alfresco.mvc.sample.domain;

import org.alfresco.service.cmr.repository.MLText;

public class CmFolder {

	private MLText cmTitle;
	private MLText cmDescription;
	private String ref;

	public MLText getCmTitle() {
		return cmTitle;
	}

	public void setCmTitle(MLText cmTitle) {
		this.cmTitle = cmTitle;
	}

	public MLText getCmDescription() {
		return cmDescription;
	}

	public void setCmDescription(MLText cmDescription) {
		this.cmDescription = cmDescription;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}
}
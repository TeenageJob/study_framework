package org.smart.plugin.common.web.pagebean.impl;

import org.smart.plugin.common.web.pagebean.IFeedBackMessage;

public class FeedBackMessage implements IFeedBackMessage {

	private String message;
	private String messageType;
	
	@Override
	public String getMessageType() {
		return this.messageType;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public void setMessageType(String type) {
		this.messageType=type;
	}

	@Override
	public void setMessage(String message) {
		this.message=message;
	}

}

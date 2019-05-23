package org.smart.plugin.common.web.pagebean;

public interface IFeedBackMessage {

	String MESSAGE_YTPE_ERROR="error";
	String MESSAGE_TYPE_INFO="info";
	String MESSAGE_TYPE_SUCCESS="success";
	String MESSAGE_TYPE_WARN="warn";
	
	String getMessageType();
	String getMessage();
	
	void setMessageType(String type);
	void setMessage(String message);
	
}

package org.smart.plugin.common.web.pagebean;

public interface IPageBean 
	extends IFeedBackMessage, IInputData, IInputProperty, ISelectData, ITableData ,ITree{
	
	String DATA_BEAN="_DATA_BEAN";
	
	void setSuccess(boolean bool);
	
	String toJson();
}

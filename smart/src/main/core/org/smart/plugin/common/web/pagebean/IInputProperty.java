package org.smart.plugin.common.web.pagebean;

import java.util.List;
import java.util.Map;

public interface IInputProperty {
	/**设置只读*/
	String READONLY = "readonly";
	/**设置可用*/
	String ENABLE = "enable";
	/**设置不可用*/
	String DISABLED = "disabled";
	/**隐藏*/
	String HIDE = "hide";
	/**显示*/
	String SHOW = "show";
	/**必填*/
	String REQUIRED = "required";
	/**取消必填*/
	String DISREQUIRED="disrequired";
	/**聚焦*/
	String FOCUS = "focus";
	/**被选中*/
	String CHECKED="checked";
	
	Map<String, List<String>> getProperty();

	List<String> getPropertyById(String id);
	
	void setReadOnly(String id);
	void setEnable(String id);
	void setDisabled(String id);
	void setHide(String id);
	void setShow(String id);
	void setRequed(String id);
	void setDisRequed(String id);
	void setFocus(String id);
	void setChecked(String id);
}

package org.smart.framework.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagText extends SimpleTagSupport{

	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public void doTag() throws JspException, IOException {
		
	}
}

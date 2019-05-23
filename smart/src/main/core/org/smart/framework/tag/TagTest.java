package org.smart.framework.tag;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagTest extends SimpleTagSupport {

	private String map;

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void doTag() throws JspException, IOException {
		// getJspContext().getOut().write("hello world!!");

		HashMap<String, Integer> maps = (HashMap<String, Integer>) (getJspContext().getAttribute(map));
		for (String str : maps.keySet()) {
			getJspContext().setAttribute("name", str);
			getJspContext().setAttribute("age", maps.get(str));
			getJspBody().invoke(null);
		}
	}
}

package org.plugin.xmlparsing.jdom;

import org.jdom2.Element;
import org.plugin.xmlparsing.SmartXMLParsing;

public class JDOMParsing implements SmartXMLParsing {

	private Element element;

	public JDOMParsing(Element el) {
		this.element = el;
	}

	@Override
	public Object getRootNod() {
		return this.element;
	}
}

package org.plugin.xmlparsing.dom;

import org.plugin.xmlparsing.SmartXMLParsing;
import org.w3c.dom.Document;

public class DOMParsing implements SmartXMLParsing{
	
	private Document document;
	
	public DOMParsing(Document doc) {
		document=doc;
	}
	@Override
	public Object getRootNod() {
		return this.document;
	}

}

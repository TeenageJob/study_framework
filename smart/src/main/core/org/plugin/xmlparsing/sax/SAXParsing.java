package org.plugin.xmlparsing.sax;

import java.util.List;
import java.util.Map;

import org.plugin.xmlparsing.SmartXMLParsing;

public class SAXParsing implements SmartXMLParsing {

	private List<Map<String, String>> list;

	public SAXParsing(List<Map<String, String>> li) {
		this.list = li;
	}

	@Override
	public Object getRootNod() {
		return this.list;
	}
}

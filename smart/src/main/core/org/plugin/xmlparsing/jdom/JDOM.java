package org.plugin.xmlparsing.jdom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.plugin.cache.CacheThread;
import org.plugin.xmlparsing.SmartParsingManager;
import org.plugin.xmlparsing.SmartXMLParsing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDOM implements SmartParsingManager{

	private static final Logger logger = LoggerFactory.getLogger(CacheThread.class);
	
	@Override
	public SmartXMLParsing getXMLInfo(String xmlPath) {
		try {
			SAXBuilder saxBuilder = new SAXBuilder();
			InputStream in = new FileInputStream(xmlPath);
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			Document document = saxBuilder.build(isr);
			return new JDOMParsing(document.getRootElement());
		} catch (JDOMException|IOException e) {
			logger.debug("解析文件失败："+xmlPath);
		} 
		return null;
	}
}

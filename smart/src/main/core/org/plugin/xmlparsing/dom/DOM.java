 package org.plugin.xmlparsing.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.plugin.cache.CacheThread;
import org.plugin.xmlparsing.SmartParsingManager;
import org.plugin.xmlparsing.SmartXMLParsing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

public class DOM implements SmartParsingManager {

	private static final Logger logger = LoggerFactory.getLogger(CacheThread.class);

	@Override
	public SmartXMLParsing getXMLInfo(String xmlPath) throws IOException {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			return new DOMParsing(db.parse(xmlPath));
		} catch (ParserConfigurationException | SAXException | IOException e) {
			logger.debug("解析文件失败：" + xmlPath);
		}
		return null;
	}
}

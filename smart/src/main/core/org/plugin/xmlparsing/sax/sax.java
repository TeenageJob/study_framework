package org.plugin.xmlparsing.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.plugin.cache.CacheThread;
import org.plugin.xmlparsing.SmartParsingManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.xml.sax.SAXException;

public class sax implements SmartParsingManager {

	private static final Logger logger = LoggerFactory.getLogger(CacheThread.class);

	@Override
	public SAXParsing getXMLInfo(String xmlPath) {
		// 创建SAXParserHandler对象
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParserHandler handler = new SAXParserHandler();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(xmlPath, handler);
			return new SAXParsing(handler.getList());
		} catch (SAXException | IOException | ParserConfigurationException e) {
			logger.debug("解析文件失败：" + xmlPath);
		}
		return null;
	}
}

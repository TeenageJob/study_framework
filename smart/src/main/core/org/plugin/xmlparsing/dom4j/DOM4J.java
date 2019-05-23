package org.plugin.xmlparsing.dom4j;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.plugin.cache.CacheThread;
import org.plugin.xmlparsing.SmartParsingManager;
import org.plugin.xmlparsing.SmartXMLParsing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.framework.util.UrlPathUtil;

public class DOM4J implements SmartParsingManager {

	private static final Logger logger = LoggerFactory.getLogger(CacheThread.class);

	@Override
	public SmartXMLParsing getXMLInfo(String xmlPath) {
		try {
			//xmlPath=UrlPathUtil.getWEB_INFUrl()+xmlPath;
			xmlPath=UrlPathUtil.getIDEAUrl();
		    SAXReader reader = new SAXReader();
			Document document = reader.read(new File(xmlPath));
			return new DOM4JParsing(document.getRootElement());
		} catch (DocumentException ex) {
			ex.printStackTrace();
			logger.debug("解析文件失败：" + xmlPath);
			throw new RuntimeException();

		} catch (Exception ec) {
			ec.printStackTrace();
		}
		return null;
	}
}

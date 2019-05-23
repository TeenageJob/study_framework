package org.plugin.xmlparsing;

import java.io.IOException;

/**
 * xml解析管理器
 * @author TY
 * @Time 2017年12月14日 下午10:46:30
 * @since 1.0.0
 */
public interface SmartParsingManager {
	
	/**
	 * 获取xml内容
	 *
	 * <br>create by on TY
	 * <br>2017年12月14日 下午9:20:53
	 * @return 头节点或List
	 */
	SmartXMLParsing getXMLInfo(String xmlPath) throws IOException;
}

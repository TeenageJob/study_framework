package org.plugin.xmlparsing;

public interface SmartXMLParsing {

	/**
	 * 返回节点
	 * 该允许直接访问文档的文档元素的子节点
	 *
	 * <br>create by on TY
	 * <br>2017年12月15日 上午9:30:59
	 * @return
	 */
	Object getRootNod();
	
	/**
	 * 遍历当前节点下的所有节点 
	 *
	 * <br>create by on TY
	 * <br>2017年12月18日 下午2:25:17
	 * @param node
	 * @return 
	 */
	//void listNodes(Object node);
	
}

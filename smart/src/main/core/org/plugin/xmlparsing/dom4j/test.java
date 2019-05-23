package org.plugin.xmlparsing.dom4j;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.plugin.xmlparsing.SmartXMLParsing;

public class test {

	public static void main(String[] args) {
		DOM4J dom4j=new DOM4J();
		SmartXMLParsing smartXMLParsing=dom4j.getXMLInfo("src/main/webapp/WEB-INF/shiro.xml");
		Element element=(Element) smartXMLParsing.getRootNod();
		listNodes(element);
	}
	
	public static void listNodes(Element node) {
		// 首先获取当前节点的所有属性节点
		System.out.println("节点名"+node.getName());
		List<Attribute> list = node.attributes();
		// 遍历属性节点
		for (Attribute attribute : list) {
			System.out.println("属性" + attribute.getName() + ":" + attribute.getValue());
		}
		// 如果当前节点内容不为空，则输出
		if (!(node.getTextTrim().equals(""))) {
			System.out.println(node.getName() + "：" + node.getText());
		}
		// 同时迭代当前节点下面的所有子节点
		// 使用递归
		Iterator<Element> iterator = node.elementIterator();
		while (iterator.hasNext()) {
			Element e = iterator.next();
			listNodes(e);
		}
	}
}

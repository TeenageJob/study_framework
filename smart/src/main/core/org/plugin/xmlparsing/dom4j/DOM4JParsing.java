package org.plugin.xmlparsing.dom4j;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.plugin.xmlparsing.SmartXMLParsing;

public class DOM4JParsing implements SmartXMLParsing {

	private Element element;

	public DOM4JParsing(Element el) {
		this.element = el;
	}

	@Override
	public Object getRootNod() {
		return this.element;
	}

	public void listNodes(Element node) {
		// 首先获取当前节点的所有属性节点
		
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

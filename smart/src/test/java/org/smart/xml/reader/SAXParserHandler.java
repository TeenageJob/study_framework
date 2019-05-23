package org.smart.xml.reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {
	/* 注意DefaultHandler是org.xml.sax.helpers包下的 */

	// 存储正在解析的元素的数据
	private Map<String, String> map = null;
	// 存储所有解析的元素的数据
	private List<Map<String, String>> list = null;
	// 正在解析的元素的名字
	String currentTag = null;
	// 正在解析的元素的元素值
	String currentValue = null;
	// 开始解析的元素
	String nodeName = null;
	// 标志：判断是否是第一次来
	private boolean flag = false;

	public SAXParserHandler() {
	}

	public List<Map<String, String>> getList() {
		return list;
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("SAX解析开始");
		list = new ArrayList<Map<String, String>>();

	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("SAX解析结束");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// 判断正在解析的元素是不是开始解析的元素
		if (!flag) {
			this.nodeName = qName;
			map = new HashMap<String, String>();
			flag = true;
		}

		// 判断正在解析的元素是否有属性值,如果有则将其全部取出并保存到map对象中，如:<person id="00001"></person>
		if (attributes != null && map != null) {
			for (int i = 0; i < attributes.getLength(); i++) {
				map.put(attributes.getQName(i), attributes.getValue(i));
			}
		}
		currentTag = qName; // 正在解析的元素
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// 判断是否为一个节点结束的元素标签
		if (qName.equals(nodeName)) {
			list.add(map);
			map = null;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (currentTag != null && map != null) {
			currentValue = new String(ch, start, length);
			// 如果内容不为空和空格，也不是换行符则将该元素名和值和存入map中
			if (currentValue != null && !currentValue.trim().equals("") && !currentValue.trim().equals("\n")) {
				map.put(currentTag, currentValue);
			}
			// 当前的元素已解析过，将其置空用于下一个元素的解析
			currentTag = null;
			currentValue = null;
		}
	}
}
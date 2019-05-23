package org.plugin.xmlparsing.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;
import java.util.Map;

public class SAXParserHandler extends DefaultHandler{
	
	/**
	 * 用来标识解析开始
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("SAX解析开始");

	}
	
	/**
	 * 用来标识解析结束
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("SAX解析结束");
	}
	
	/**
	 * 用来遍历xml文件的开始标签 解析xml元素
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// 调用DefaultHandler类的startElement方法
		super.startElement(uri, localName, qName, attributes);
	}
	
	/**
	 * 用来遍历xml文件的结束标签
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// 调用DefaultHandler类的endElement方法
		super.endElement(uri, localName, qName);
	}
	
	
	/**
	 * 获取文本 重写charaters()方法时， String(byte[] bytes,int offset,int
	 * length)的构造方法进行数组的传递 去除解析时多余空格
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		/**
		 * ch 代表节点中的所有内容，即每次遇到一个标签调用characters方法时，数组ch实际都是整个XML文档的内容
		 * 如何每次去调用characters方法时我们都可以获取不同的节点属性？这时就必须结合start（开始节点）和length（长度）
		 */
		super.characters(ch, start, length);
	}
	
	
	/**
	 * qName获取的是节点名（标签） value获取的是文本（开始和结束标签之间的文本）
	 * 思考：qName和value分别在两个方法中，如何将这两个方法中的参数整合到一起？
	 * 分析：要在两个方法中用同一个变量，就设置成全局变量，可以赋初值为null。 可以把characters()方法中的value作成一个全局变量
	 * 
	 * 然后在endElement()方法中对book对象进行塞值。记得要把Book对象设置为全局变量，变量共享
	 */



	List<Map<String, String>> getList(){
		return null;
	}
}

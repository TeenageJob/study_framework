package org.smart.xml.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *  JDOM 解析XML
 */
public class JDOMTest {
    private static ArrayList<Book> booksList = new ArrayList<Book>();

    public static void main(String[] args) {
        // 进行对books.xml文件的JDOM解析
        //❤准备工作
        // 1.创建一个SAXBuilder的对象
        SAXBuilder saxBuilder = new SAXBuilder();//注意SAXBuilder是org.jdom2.input包下的
        InputStream in;
        try {
            // 2.创建一个输入流，将xml文件加载到输入流中
            in=new FileInputStream("src/test/java/org/smart/xml/reader/jurisdiction.xml");//如果将xml文件放在src/res包下，此时应该输入“src/res/books.xml”
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");//使用包装流InputStreamReader进行读取编码的指定，防止乱码
            // 3.通过saxBuilder的build方法，将输入流加载到saxBuilder中
            Document document = saxBuilder.build(isr);
            // 4.通过document对象获取xml文件的根节点
            Element rootElement = document.getRootElement();
            // 5.获取根节点下的子节点的List集合
            List<Element> bookList = rootElement.getChildren();
            //❤ 继续解析，采用for循环对bookList进行遍历
            for (Element book : bookList) {
                Book bookEntity = new Book();
                System.out.println("======开始解析第" + (bookList.indexOf(book) + 1) + "书======");//indexOf()返回的是index的位置，是从0开始
                // 解析book的属性集合
                List<Attribute> attrList = book.getAttributes();//适用于未知属性情况下
                /*//知道节点下属性名称时，获取节点值
                book.getAttributeValue("id");*/
                // 遍历attrList(针对不清楚book节点下属性的名字及数量)
                for (Attribute attr : attrList) {
                    /**注：JDom中，Attribute的getName和getValue方法获取到的都是实际的名称和值，
                     * 不会出现SAX和DOM中的空格和换行的情况*/
                    // 获取属性名
                    String attrName = attr.getName();
                    // 获取属性值
                    String attrValue = attr.getValue();
                    System.out.println("属性名：" + attrName + "----属性值：" + attrValue);
                    if (attrName.equals("id")) {
                        bookEntity.setId(attrValue);
                       }
                }
                
                //❤对book节点的子节点的节点名以及节点值的遍历
                List<Element> bookChilds = book.getChildren();
                for (Element child : bookChilds) {
                    System.out.println("节点名：" + child.getName() + "----节点值：" + child.getValue());
                    if (child.getName().equals("name")) {
                        bookEntity.setName(child.getValue());
                       }
                       else if (child.getName().equals("author")) {
                        bookEntity.setAuthor(child.getValue());
                       }
                       else if (child.getName().equals("year")) {
                        bookEntity.setYear(child.getValue());
                       }
                       else if (child.getName().equals("price")) {
                        bookEntity.setPrice(child.getValue());
                       }
                       else if (child.getName().equals("language")) {
                        bookEntity.setLanguage(child.getValue());
                       }

                }
                System.out.println("======结束解析第" + (bookList.indexOf(book) + 1) + "书======");
                booksList.add(bookEntity);
                bookEntity = null;
                //测试数据
                System.out.println(booksList.size());
                System.out.println(booksList.get(0).getId());
                System.out.println(booksList.get(0).getName());

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
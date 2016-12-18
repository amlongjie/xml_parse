package sax;

import bean.Student;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Administrator on 2016/12/18.
 */
// 获得所有学生信息,并保存下来
public class SaxXMLReader extends DefaultHandler{

    private Student student;
    private String curString;
    @Override
    public void startDocument() throws SAXException {
        System.out.println("文档开始了");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("文档结束了");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //qName 就是 触发startElement方法时候的元素是哪一个
        //attributes 就是触发startElement方法的元素上的属性
        if("student".equals(qName)){
            student = new Student();
            student.setNumber(attributes.getValue("number"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("name".equals(qName)) {
            student.setName(curString);
        }
        if("age".equals(qName)) {
            student.setAge(curString);
        }
        if("sex".equals(qName)){
            student.setSex(curString);
        }
        if("student".equals(qName))
            System.out.println(student);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // characters 是 文本事件,当读取完一段文本后调用.
        curString = new String(ch, start, length);
    }
}

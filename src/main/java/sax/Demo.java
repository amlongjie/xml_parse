package sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/18.
 */
public class Demo {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //1. 获取解析器类工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2. 获得解析器
        SAXParser saxParser = factory.newSAXParser();
        //3. 解析文档
        saxParser.parse(Demo.class.getClassLoader().getResourceAsStream("students.xml"), new SaxXMLReader());
    }
}

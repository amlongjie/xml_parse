package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 * Created by lilongjie on 16/12/19.
 */
// 读取 XML
public class Demo1 {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(Demo1.class.getClassLoader().getResourceAsStream("students.xml"));
        System.out.println(document.asXML());
    }
}

package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by lilongjie on 16/12/19.
 */
// 使用XPATH,更新节点itcast_0001为 rose 16 female
public class Demo6 {
    public static void main(String[] args) throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(Demo6.class.getClassLoader().getResourceAsStream("students.xml"));
        //1. 根据XPath得到节点
        Element element = (Element) document.selectSingleNode("//student[@number='itcast_0001']");
        element.element("name").setText("rose");
        element.element("age").setText("16");
        element.element("sex").setText("female");
        //3. 将document写到文件中.
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/main/resources/student_update.xml"), outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();

    }
}

package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by lilongjie on 16/12/19.
 */
// 这个思路可以,但是效率低.
// 删除节点itcast_0001
public class Demo4 {
    public static void main(String[] args) throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(Demo4.class.getClassLoader().getResourceAsStream("students.xml"));
        Element root = document.getRootElement();
        // 遍历所有student节点
        for(Iterator<Element> it = root.elementIterator("student"); it.hasNext();){
            Element element = it.next();
            // 判断.
            if(element.attributeValue("number").equals("itcast_0001")){
                // 移除
                root.remove(element);
            }
        }
        //4. 将document写到文件中.
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/main/resources/student_delete.xml"), outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();

    }
}

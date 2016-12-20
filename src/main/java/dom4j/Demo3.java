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
// 增加一个学生
public class Demo3 {
    public static void main(String[] args) throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(Demo3.class.getClassLoader().getResourceAsStream("students.xml"));
        //1. 获得根元素
        Element element = document.getRootElement();
        //2. 给添加一个Element,student,添加number属性
        Element student = element.addElement("student").addAttribute("number", "itcast_0003");
        //3. 添加name,age,sex三个子元素,并添加子元素中的文本.
        student.addElement("name").addText("杰克");
        student.addElement("age").addText("19");
        student.addElement("sex").addText("male");
        //4. 将document写到文件中.
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/main/resources/student_add.xml"), outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();
    }
}

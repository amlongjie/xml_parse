package dom;

import bean.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/18.
 */
public class Demo {
    // 获得所有学生信息
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //1. 获得jaxp工厂
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //2. 通过工厂获得解析器类实现类
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        //3. 使用解析器加载xml文档 => 返回 document
        Document document = builder.parse(Demo.class.getClassLoader().getResourceAsStream("students.xml"));
        //4. 获得所有学生元素的集合
        NodeList students = document.getElementsByTagName("student");
        //5. 遍历集合
        for(int i=0; i < students.getLength(); i++){
            Student s = new Student();
            Element student = (Element) students.item(i);
            String number = student.getAttribute("number");
            s.setNumber(number);
            // 获得student下的所有孩子节点,包括空格一共七个
            NodeList children = student.getChildNodes();
            for(int j=0; j < children.getLength(); j++){
                Node node = children.item(j);
               // 获取想要的属性的Element节点
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element child = (Element) node;
                    if(child.getNodeName().equals("name")){
                        String name = child.getTextContent();
                        s.setName(name);
                    }
                    if(child.getNodeName().equals("age")){
                        String age = child.getTextContent();
                        s.setAge(age);
                    }
                    if(child.getNodeName().equals("sex")){
                        String sex = child.getTextContent();
                        s.setSex(sex);
                    }
                }
            }
            System.out.println(s);
        }
    }
}

package dom4j;

import bean.Student;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;


/**
 * Created by lilongjie on 16/12/19.
 */
// 查询出所有学生的所有信息
public class Demo2 {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(Demo1.class.getClassLoader().getResourceAsStream("students.xml"));
        // 1.获得根元素
        Element root = document.getRootElement();
        // 2.迭代根元素下的所有名叫student的子元素
        for(Iterator<Element> it = root.elementIterator("student");it.hasNext();){
            Element element = it.next();
            Student student = new Student();
            // 3.获得student元素的Numer属性
            student.setNumber(element.attributeValue("number"));
            // 4.student子元素的内容(name,age,sex)
            student.setName(element.elementText("name"));
            student.setAge(element.elementText("age"));
            student.setSex(element.elementText("sex"));
            System.out.println(student);
        }
    }
}

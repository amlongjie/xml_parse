package bean;

/**
 * Created by Administrator on 2016/12/18.
 */
public class Student {
    private String name;
    private String age;
    private String sex;
    private String number;

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

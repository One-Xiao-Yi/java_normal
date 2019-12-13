/**
 * FileName: Person
 * Author: xiaoyi
 * Description:    person
 * Date:   2019/12/217:16
 */

package colectionpackage;

public class Person {

    public String name;

    public int age;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

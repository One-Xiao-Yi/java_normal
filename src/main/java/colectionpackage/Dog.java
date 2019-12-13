/**
 * FileName: Dog
 * Author: xiaoyi
 * Description:    dog
 * Date:   2019/12/217:16
 */

package colectionpackage;

import java.util.Objects;

public class Dog {

    public String name;
    public int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Dog)
        {
            Dog dog = (Dog) obj;
            return Objects.equals(this.name, dog.name) && this.age == dog.age;
        }
        return false;
    }

    @Override
    public int hashCode() {
        /*
        重写hashCode原理示例
        int h = 0;
        h = 31 * h + name.hashCode();
        h = 31 * h + age;
        return h;
        */
        return Objects.hash(name, age);
    }
}

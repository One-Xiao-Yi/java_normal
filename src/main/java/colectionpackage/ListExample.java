package colectionpackage;

import java.util.List;

public class ListExample {

    public static void main(String[] args) {

        List<String> list = List.of("a", "b", "c", "d");

        //判断list中是否包含某元素
        System.out.println(list.contains("a"));
        //判断是否包含元素，内部使用的式equals方法判断，所以不同空间的字符串也会返回true
        System.out.println(list.contains(new String("a")));
        //java在基本数据类型内部重写了equals方法，但如果存储的是自己编写的对象，则无法使用该方法判断
        List<Person> people = List.of(new Person("wang"), new Person("hao"));
        System.out.println(people.contains(new Person("wang")));
        //所以我们需重写equals方法，使其支持该方法。
        //重写equals方法条件：
        //1. 自反性（Reflexive）:对于非null的x，x.equals(x)必须返回true；
        //2. 对称性（Symmetric）:对于非null的x、y,如果x.equals(y)为true，则y.equals(x)也为true；
        //3. 传递性（Transitive）:对于非null的x、y、z，如果x.equals(y)为true，y.equals(z)为true，则x.equals(z)也为true；
        //4. 一致性（Consistent）:对于非null的x、y，只要x、y状态不变，则x.equals(y)总是一致的返回true或false；
        //x.equals(null)永远返回false。

        List<Dog> dogs = List.of(new Dog("teddy", 3), new Dog("lucky", 6));
        System.out.println(dogs.contains(new Dog("lucky", 6)));

        //重写equals方法的步骤：
        //1.确定实例相等逻辑，既那些字段相等，则实例相同
        //2.判断传入的实例是否为当前类型（instanceof）
        //3.对引用类型字段用Objects.equals比较，对基本类型使用==比较

        //返回某元素在list中的索引，若不存在则返回-1
        System.out.println(list.indexOf("c"));
        System.out.println(list.indexOf("e"));

    }

}



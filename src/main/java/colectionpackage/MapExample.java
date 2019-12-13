/**
 * FileName: MapExample
 * Author: xiaoyi
 * Description:    map
 * Date:   2019/12/217:20
 */

package colectionpackage;

import java.time.DayOfWeek;
import java.util.*;

/*
*  map将value用类似于LinkedList的形式存储在内存中，通过key计算出value的索引，实现key-value的对应
*
*   map：   key：           a                         b                       c
*                           |                        |                        |
*  内存： value： list<entry<a, valueA>>  list<entry<a, valueB>>  list<entry<a, valueC>>
* */

public class MapExample {

    public static void main(String[] args) {

        // hashMap();
        // enumMap();
        // treeMap();

    }

    public static void hashMap()
    {
        Map<String, Person> map = new HashMap<>();
        map.put("wang", new Person("wang"));
        map.put("hao", new Person("hao"));

        //map的put方法，当放入的值存在时，将返回被替换掉的value
        //若不存在，则返回null
        System.out.println(map.put("wang", new Person("hao")).name);
        System.out.println(map.get("wang").name);
        System.out.println(null == map.put("jie", new Person("jie")));


        //map中对于key的相同的比较使用的时equals
        String key1 = "a";
        map.put(key1, new Person("key1"));
        String key2 = new String("a");
        System.out.println(map.put(key2, new Person("key2")).name);

        //所以，当map的key为自定义的类型，则需考虑是否重写equals方法
        //同样的，通过key计算value的索引，相同的key对象要计算出相同的value索引，所以hashCode方法也要考虑是否重写
        //因此，正确使用map必须保证：
        // 1.key对象必须正确重写equals方法
        // 2.key对象必须正确重写hashCode方法，且遵循以下规则：
        //      如果两个对象相同，则对应的hashCode必须相同
        //      如果两个对象不同，相对应的hashCode尽量不同
        //重写hashCode的规则是，在equals中比较的每一个字段都需要计算，没有使用的不能计算。

        //未重写equals和hashCode示例
        Map<Person, String> unHashMap = new HashMap<>();
        Person wang = new Person("wang");
        Person hao = new Person("wang");
        unHashMap.put(wang, "a");
        System.out.println(unHashMap.put(hao, "a"));

        //重写equals和hashCode示例
        Map<Dog, String> hashMap = new HashMap<>();
        Dog teddy = new Dog("teddy", 14);
        Dog lucky = new Dog("teddy", 14);
        hashMap.put(teddy, "a");
        System.out.println(hashMap.put(lucky, "a"));

        // map的初始容量未16，容量不够时，将会自动加倍，但是自动加倍需要重新计算hashCode，会影响性能，所以尽可能的在map定义时，定义map的容量。
        Map mapSize = new HashMap(10000);
        // 设定map容量为10000，但实际存储时，数组长度为2的n次方，因此，实际长度为16384（2的14次方）

        // 如果key1("a")与key2("b")恰好hashCode相同怎么办。
        // 其实在HashMap的value数组中，存储的不是一个对象实例，而是一个List<Entry<Object, Object>>。
        // 它包含两个entry，一个是key1的映射，一个是key2的映射。
        // 当访问到该地址时，还需遍历该list，查找对应的value
        // 上面这种情况，叫做哈希冲突。
        // 一种最简单的解决方法是用上述的List存储，但是冲突越多，list越长，则越影响效率。
    }

    public static void enumMap()
    {
        //EnumMap是key为枚举类型的map，value通过非常紧凑的数组进行存储，可通过key直接定位value，无需计算hashCode，更有效率，没有额外的空间消耗。
        Map<DayOfWeek, String> enumMap = new EnumMap<DayOfWeek, String>(DayOfWeek.class);
        enumMap.put(DayOfWeek.MONDAY, "星期一");
        enumMap.put(DayOfWeek.TUESDAY, "星期二");
        enumMap.put(DayOfWeek.WEDNESDAY, "星期三");
        enumMap.put(DayOfWeek.THURSDAY, "星期四");
        enumMap.put(DayOfWeek.FRIDAY, "星期五");
        enumMap.put(DayOfWeek.SATURDAY, "星期六");
        enumMap.put(DayOfWeek.SUNDAY, "星期日");
        System.out.println(enumMap);
        System.out.println(enumMap.get(DayOfWeek.SATURDAY));
    }

    public static void treeMap()
    {
        //TreeMap是可以根据key值进行排序的map
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("a", 1);
        treeMap.put("c", 3);
        treeMap.put("b", 2);
        for(String key:treeMap.keySet())
        {
            System.out.println(key);
        }

        //使用TreeMap时，key必须实现Comparable接口。如果未实现该接口，则需指定自定义排序规则，未自定义则抛出异常。
        Map<Person, Integer> personMap = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        personMap.put(new Person("Wang"), 2);
        personMap.put(new Person("Hao"), 1);
        for(Person key:personMap.keySet())
        {
            System.out.println(key.name);
        }

        //Comparator需实现一个比较算法，a<b，则返回-1，以此类推。
        //TreeMap不使用equals和hashCode
        Map<Person, Integer> ageMap = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.age == o2.age)
                {
                    return 0;
                }
                return o1.age > o2.age ? -1 : 1;
            }
        });
        Person wang = new Person("wang");
        wang.age = 10;
        Person hao = new Person("hao");
        hao.age = 14;
        ageMap.put(hao, 2);
        ageMap.put(wang, 1);
        for(Person key:ageMap.keySet())
        {
            System.out.println(key.name);
        }

    }

}

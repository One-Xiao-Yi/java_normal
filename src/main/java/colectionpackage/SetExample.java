/**
 * FileName: SetExample
 * Author: xiaoyi
 * Description:    set
 * Date:   2019/12/312:16
 */

package colectionpackage;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

    public static void main(String[] args) {
        // hashSet();
        treeSet();
    }

    public static void hashSet()
    {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        for (String key:hashSet)
        {
            System.out.println(key);
        }
    }

    public static void treeSet()
    {
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("c");
        treeSet.add("a");
        treeSet.add("b");
        for (String key:treeSet)
        {
            System.out.println(key);
        }
    }

}

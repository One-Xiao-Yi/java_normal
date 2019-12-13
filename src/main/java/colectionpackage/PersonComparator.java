/**
 * FileName: PersonComparator
 * Author: xiaoyi
 * Description:    person排序规则
 * Date:   2019/12/312:56
 */

package colectionpackage;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if(o1.name.charAt(0) == o2.name.charAt(0))
        {
            if(o1.age == o2.age)
            {
                return 0;
            }
            return o1.age > o2.age ? -1 : 1;
        }else
        {
            return o1.name.compareTo(o2.name);
        }
    }
}

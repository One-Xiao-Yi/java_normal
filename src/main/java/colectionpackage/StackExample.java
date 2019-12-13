/**
 * FileName: StackExample
 * Author: xiaoyi
 * Description:    Stack
 * Date:   2019/12/313:17
 */

package colectionpackage;


import java.util.ArrayDeque;
import java.util.Deque;

/*
*  Stack是一种后进后出的队列（LIFO：Last In First Out）
*  因为有一个类名称是Stack，所以没有Stack接口，只能使用Deque来模拟Stack
*  使用Deque，只需将头部(或尾部)封死，不使用头部相关方法，既可模拟Stack
* */
public class StackExample {

    public static void main(String[] args) {

        System.out.println(toHex(23534));

    }

    public static String toHex(int n)
    {
        Deque<String> stack = new ArrayDeque<>();
        while (n / 16 != 0)
        {
            stack.push(Integer.toHexString(n % 16));
            n = n / 16;
        }
        stack.push(Integer.toHexString(n));
        StringBuilder stringBuilder = new StringBuilder();
        while (null != stack.peek())
        {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

}

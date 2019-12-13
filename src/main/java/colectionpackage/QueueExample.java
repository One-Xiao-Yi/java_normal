/**
 * FileName: QueueExample
 * Author: xiaoyi
 * Description:    queue
 * Date:   2019/12/312:31
 */

package colectionpackage;

import java.util.*;

/*
*  Queue 是一种实现了先进先出（FIFO：First In First Out）的有序表，Queue只有两种操作：
*  1.把元素添加到队列末尾
*  2.从队列头部取出元素
*
*  Queue常用方法为：
*  1.size 获取长度
*  2.add|offer  在末尾添加元素
*  3.remove|poll    获取头部元素并移除
*  4.element|peek   获取头部元素不移除
*  2、3、4操作有两种实现方法，不同点在于，前者当执行出错时会抛出异常（溢出、空队列），
*  而后者会返回false（添加元素）或null（获取元素）
*
*  LinkedList 既实现List，又实现Queue
* */
public class QueueExample {

    public static void main(String[] args) {

        // linkedList();
        // priorityQueue();
        // deque();
    }

    public static void linkedList()
    {
        Queue<String> queue = new LinkedList<>();

        try {
            String s = queue.remove();
            System.out.println("remove获取删除成功");
        }catch (NoSuchElementException e)
        {
            System.out.println("remove获取删除失败");
        }

        if(null != queue.poll())
        {
            System.out.println("poll获取删除成功");
        }else {
            System.out.println("poll获取删除失败");
        }

        try {
            String s = queue.element();
            System.out.println("element获取删除成功");
        }catch (NoSuchElementException e)
        {
            System.out.println("element获取删除失败");
        }

        if(null != queue.peek())
        {
            System.out.println("peek获取删除成功");
        }else {
            System.out.println("peek获取删除失败");
        }

        try {
            queue.add("a");
            System.out.println("add操作添加成功");
        }catch (IllegalStateException e)
        {
            System.out.println("add操作添加失败");
        }

        if(queue.offer("a")){
            System.out.println("offer操作添加成功");
        }else {
            System.out.println("offer操作添加失败");
        }
    }

    public static void priorityQueue()
    {
        // PriorityQueue是一种可以排序出队的队列，类似于TreeSet，可以指定排序规则
        Queue<String> queue = new PriorityQueue<>();
        queue.offer("b");
        queue.offer("g");
        queue.offer("a");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        Queue<Person> personQueue = new PriorityQueue<>(new PersonComparator());
        Person person1 = new Person("abc");
        person1.age = 12;
        Person person2 = new Person("ac");
        person2.age = 13;
        Person person3 = new Person("ab");
        person3.age = 14;
        Person person4 = new Person("bc");
        person4.age = 12;
        personQueue.offer(person4);
        personQueue.offer(person3);
        personQueue.offer(person2);
        personQueue.offer(person1);
        System.out.println(personQueue.poll());
        System.out.println(personQueue.poll());
        System.out.println(personQueue.poll());
        System.out.println(personQueue.poll());
        System.out.println(personQueue.poll());
    }

    public static void deque()
    {
        Queue<String> deque = new ArrayDeque<>();
        deque.offer("c");
        ((ArrayDeque<String>) deque).addFirst("b");
        ((ArrayDeque<String>) deque).offerFirst("a");
        ((ArrayDeque<String>) deque).addLast("d");
        ((ArrayDeque<String>) deque).offerLast("e");
        System.out.println(((ArrayDeque<String>) deque).peekFirst());
        System.out.println(((ArrayDeque<String>) deque).peekLast());
        System.out.println(((ArrayDeque<String>) deque).getFirst());
        System.out.println(((ArrayDeque<String>) deque).getLast());
        System.out.println(((ArrayDeque<String>) deque).pollFirst());
        System.out.println(((ArrayDeque<String>) deque).pollLast());
        System.out.println(((ArrayDeque<String>) deque).removeFirst());
        System.out.println(((ArrayDeque<String>) deque).removeLast());
    }

}

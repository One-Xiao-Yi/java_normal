/**
 * FileName: ReentrantTaskQueue
 * Author: xiaoyi
 * Description:    尝试获取锁类
 * Date:   2019/12/1316:02
 */

package threadpackage;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantTaskQueue {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Deque<String> queue = new LinkedList<>();

    public void addTask(String task)
    {
        lock.lock();
        this.queue.add(task);
        // signalAll 唤醒所有需获取该锁的等待的线程
        condition.signalAll();
        lock.unlock();
    }

    public String getTask() throws InterruptedException
    {
        lock.lock();
        try {
            while (queue.isEmpty())
            {
                // await 线程等待，并释放锁
                condition.await();
            }
            return queue.remove();
        }finally {
            lock.unlock();
        }
    }

}

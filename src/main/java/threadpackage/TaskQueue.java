/**
 * FileName: TaskQueue
 * Author: xiaoyi
 * Description:    同步队列
 * Date:   2019/12/818:56
 */

package threadpackage;

import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {

    private Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String task)
    {
        this.queue.add(task);
        // notify 唤醒所有需获取该锁的等待的线程
        this.notify();
    }

    public synchronized String getTask() throws InterruptedException
    {
        while (queue.isEmpty())
        {
            // wait 线程等待，并释放锁
            this.wait();
        }
        return queue.remove();
    }

}

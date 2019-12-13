/**
 * FileName: ReentrantLock
 * Author: xiaoyi
 * Description:    尝试获取锁
 * Date:   2019/12/1316:02
 */

package threadpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReentrantLock {

    public static void main(String[] args) {
        final int size = 10;

        ReentrantTaskQueue taskQueue = new ReentrantTaskQueue();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2 * size);
        for(int i=0;i<size;i++)
        {
            fixedThreadPool.submit(() ->
            {
                System.out.println(Thread.currentThread());
                try {
                    System.out.println(Thread.currentThread() + taskQueue.getTask());
                }catch (InterruptedException e){}

            });
        }

        for(int i=0;i<size + 1;i++)
        {
            fixedThreadPool.submit(() ->
            {
                System.out.println(Thread.currentThread());
                taskQueue.addTask(Thread.currentThread().getName());
                System.out.println("add task");
            });
        }
    }

}

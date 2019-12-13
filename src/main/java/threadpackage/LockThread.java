/**
 * FileName: LockThread
 * Author: xiaoyi
 * Description:    同步锁
 * Date:   2019/12/817:16
 */

package threadpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockThread {

    public static void main(String[] args) throws InterruptedException{

        // normalLock();
        final int size = 10;

        TaskQueue taskQueue = new TaskQueue();
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

    public static void normalLock() throws InterruptedException
    {
        Thread add = new Thread(new AddThread());
        Thread dec = new Thread(new DecThread());
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println("Main " + Counter.count);
    }

}

class Counter{
    public static int count = 0;
    public static int time = 50;
}

class AddThread implements Runnable
{

    @Override
    public void run() {
        for(int i=0;i<Counter.time;i++)
        {
            synchronized (Counter.class)
            {
                Counter.count++;
            }
            System.out.println("Add Thread " + Counter.count);
        }
    }
}

class DecThread implements Runnable
{

    @Override
    public void run() {
        for(int i=0;i<Counter.time;i++)
        {
            synchronized (Counter.class)
            {
                Counter.count--;
            }
            System.out.println("Dec Thread " + Counter.count);
        }
    }
}

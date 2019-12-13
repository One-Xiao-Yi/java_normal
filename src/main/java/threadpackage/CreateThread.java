/**
 * FileName: CreateThread
 * Author: xiaoyi
 * Description:    创建线程
 * Date:   2019/12/816:29
 */

package threadpackage;

import java.util.concurrent.*;

public class CreateThread {

    public static void main(String[] args) {

        //创建新线程的四种方式
        //1.通过继承Thread实现
        Thread thread = new MyThread();
        thread.start();

        //2.通过实现Runnable接口实现
        Thread runnable = new Thread(new MyRunnable());
        runnable.start();

        //3.通过实现Callable接口实现
        Callable<String> callable = new MyCall();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread call = new Thread(futureTask);
        call.start();
        try {
            System.out.println("main get" + futureTask.get());
        }catch (InterruptedException | ExecutionException e)
        {
            e.printStackTrace();
        }

        //4.通过线程池实现
        //FixedThreadPool 固定大小的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        fixedThreadPool.submit(new MyRunnable());
        fixedThreadPool.shutdown();

        //SingleThreadExecutor 单线程线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++)
        {
            singleThreadExecutor.submit(() ->
                    System.out.println("single" + Thread.currentThread())
            );
        }

        //CachedThreadPool 缓存线程池
        //会不断的创建新线程
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.submit(() ->
                        System.out.println("cached" + Thread.currentThread())
                );


    }



}

class MyThread extends Thread
{
    @Override
    public void run() {
        System.out.println("Thread" + Thread.currentThread());
    }
}

class MyRunnable implements Runnable
{

    @Override
    public void run() {
        System.out.println("Runnable" + Thread.currentThread());
    }
}

class MyCall implements Callable<String>
{

    @Override
    public String call() throws Exception {
        System.out.println("Callable" + Thread.currentThread());
        return "call thread";
    }
}
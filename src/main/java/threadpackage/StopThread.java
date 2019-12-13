/**
 * FileName: Main
 * Author: xiaoyi
 * Description:    线程
 * Date:   2019/12/417:50
 */

package threadpackage;

/*
线程与进程：
    在计算机中，把一个任务称为一个进程，比如QQ、音乐。
    操作系统最小任务单位是线程。
    一个进程可以有多个线程。

线程的状态：
    1.New：新创建的线程，尚未执行
    2.Runnable：运行中的线程
    3.Blocked：运行中，因为某些操作被阻塞而挂起
    4.Waiting：运行中，因为某些操作在等待
    5.Timed Waiting：运行中，因为执行sleep方法正在计时等待
    6.Terminated：已终止

线程终止的原因：
    1.正常终止：run方法执行到return返回
    2.意外终止：因为未捕获的异常导致终止
    3.调用stop方法强制终止

volatile:
    在jvm虚拟机中，变量的值存在主内存中，当有线程访问时，将创建一个副本，保存在线程的内存中。
    所以当某一线程更改变量的值时，只修改了它该副本，而为修改主内存，所以其他线程都不能及时的获取到变量值的改变。
    volatile的作用就是告诉虚拟机：
    1.每次访问变量时，总是获取主内存中的最新值
    2.每次修改变量后，立刻回写到主内存中
 */

public class StopThread {

    public static void main(String[] args) {

        // stopThread1();
        // stopThread2();

    }

    private static void stopThread1()
    {
        Thread thread1 = new Thread(() -> {

            Thread thread2 = new Thread(() -> {
                System.out.println("thread2 start");
                int n = 0;
                while ( !Thread.interrupted() ){
                    n++;
                    System.out.println(n + "hello");
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e)
                    {
                        System.out.println("thread2 Interrupted");
                        break;
                    }
                }
                System.out.println("start2 end");
            });
            thread2.start();
            try {
                thread2.join();
            }catch (InterruptedException e)
            {
                System.out.println("thread1 Interrupted");
            }
            thread2.interrupt();

        });

        thread1.start();
        try {
            //等待此线程终止后，执行后续代码
            Thread.sleep(1000);
            //通过interrupt停止线程
            thread1.interrupt();
            thread1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("main");
    }

    private static void stopThread2()
    {
        Thread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        ((MyThread) thread).running = false;
    }

    static class MyThread extends Thread{

        public volatile boolean running = true;

        @Override
        public void run() {
            System.out.println("my thread start");
            int n = 0;
            while ( running ){
                n++;
                System.out.println(n + "hello");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e)
                {
                    System.out.println("my thread Interrupted");
                    break;
                }
            }
            System.out.println("start end");
        }
    }

}

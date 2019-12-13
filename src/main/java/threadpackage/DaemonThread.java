/**
 * FileName: DaemonThread
 * Author: xiaoyi
 * Description:    守护线程
 * Date:   2019/12/817:02
 */

package threadpackage;

/*
当所有线程运行结束，JVM进程就会退出，当有线程未结束，则无法退出。
当有线程需要持续进行，又需要退出JVM进程，则需要使用守护线程。
无论守护线程有没有结束，其他线程结束时，JVM进程即可退出。

守护线程是为其他线程服务的线程
守护线程不能持有需关闭的资源，否则当虚拟机退出时，会导致数据丢失。
 */

public class DaemonThread {

    public static void main(String[] args) {
        Thread thread = new MyDaemonThread();
        thread.setDaemon(true);
        thread.start();
    }

}

class MyDaemonThread extends Thread
{
    @Override
    public void run() {
        System.out.println("Daemon Thread Start");
        while (true)
        {
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("Daemon Thread Restart");
        }
    }
}

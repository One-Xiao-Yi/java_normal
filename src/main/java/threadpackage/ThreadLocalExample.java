/**
 * FileName: ThreadLocalExample
 * Author: xiaoyi
 * Description:    ThreadLocal
 * Date:   2019/12/1417:26
 */

package threadpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 在一个线程中，横跨若干个方法，需要传递的对象，统称为上下文（Context），它是一种状态，比如身份信息、任务信息
 * 为每一个方法增加一个context参数比较麻烦，且某些第三方库无法修改源码，context无法传递。
 * ThreadLocal可以在一个线程中传递同一个对象。
 */

public class ThreadLocalExample {

    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(3);
        String[] users = new String[] { "Bob", "Alice", "Tim", "Mike", "Lily", "Jack", "Bush" };
        for (String user : users) {
            es.submit(new ThreadLocalTask(user));
        }
        es.awaitTermination(3, TimeUnit.SECONDS);
        es.shutdown();
    }

}

class UserContext implements AutoCloseable
{

    static final ThreadLocal<String> ctx = new ThreadLocal<>();

    public UserContext(String user)
    {
        ctx.set(user);
    }

    public static String currentUser()
    {
        return ctx.get();
    }

    @Override
    public void close() throws Exception {
        ctx.remove();
    }
}

class ThreadLocalTask implements Runnable
{

    private String user;

    ThreadLocalTask(String user)
    {
        this.user = user;
    }

    @Override
    public void run() {
        try (UserContext ctx = new UserContext(user)){
            new Task1().process();
            new Task2().process();
            new Task3().process();
        }catch (Exception e){}
    }
}

class Task1 {
    public void process() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.printf("[%s] check user %s...\n", Thread.currentThread().getName(), UserContext.currentUser());
    }
}

class Task2 {
    public void process() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.printf("[%s] %s registered ok.\n", Thread.currentThread().getName(), UserContext.currentUser());
    }
}

class Task3 {
    public void process() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.printf("[%s] work of %s has done.\n", Thread.currentThread().getName(),
                UserContext.currentUser());
    }
}

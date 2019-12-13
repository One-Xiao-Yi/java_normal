/**
 * FileName: CallableThread
 * Author: xiaoyi
 * Description:    带返回值的线程
 * Date:   2019/12/1317:41
 */

package threadpackage;

import java.util.concurrent.*;

public class CallableThread {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        /**
         * Callable 是一个带返回值的线程
         * Future 可以获取线程结束后的返回值
         */
        Callable<String> task = new Task();
        Future<String> future = executorService.submit(task);
        try {
            if(future.isDone())
            {
                String result = future.get();
                /**
                 * get(long timeout, TimeUnit unit) 获取返回值，但只等待固定时间
                 * cancel(boolean mayInterruptIfRunning) 取消当前任务
                 * isDone() 判断任务是否完成
                 */
                System.out.println(result);
            }
            System.out.println("here");
        }catch (InterruptedException | ExecutionException e){}

        executorService.shutdown();
    }

}

class Task implements Callable<String>
{

    private String result;

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName();
    }
}

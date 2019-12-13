/**
 * FileName: CompletableFutureThread
 * Author: xiaoyi
 * Description:    带回调方法的callable
 * Date:   2019/12/1318:23
 */

package threadpackage;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureThread {

    public static void main(String[] args) throws Exception{

        // nest();
        marge();

    }

    public static void marge() throws Exception
    {
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() ->
        {
            return getString();
        });
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() ->
        {
            return joinString(Thread.currentThread().getName());
        });
        /**
         * 将两个异步线程合并，当其中任何一个任务结束，即可执行回调方法
         * anyOf 表示任意一个任务完成
         * allOf 表示所有任务必须全部完成
         */
        CompletableFuture<Object> margeFuture = CompletableFuture.anyOf(completableFuture1, completableFuture2);
        margeFuture.thenAccept((result) ->
        {
            System.out.println(result);
        });

        Thread.sleep(2000);
    }

    public static void nest() throws Exception
    {
        /**
         * CompletableFuture 可以定义回调函数，根据任务的运行结果（成功、异常），调用不同的方法。
         */
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(CompletableFutureThread::getString);
        /**
         * 可以嵌套使用，当上一个任务执行完成之后，执行下一个任务，并可使用上一个任务的返回值
         */
        CompletableFuture<String> completableFuture1 = completableFuture.thenApplyAsync((result) ->
        {
            return joinString(result);
        });

        completableFuture1.thenAccept((result) ->
        {
            System.out.println(result);
        });


        completableFuture.exceptionally((e) ->
        {
            e.printStackTrace();
            return null;
        });

        Thread.sleep(2000);
    }

    static String getString()
    {
        return Thread.currentThread().getName();
    }

    static String joinString(String name)
    {
        return "Thread Name = " + name;
    }



}

/**
 * FileName: ThreadPool
 * Author: xiaoyi
 * Description:    线程池
 * Date:   2019/12/1317:19
 */

package threadpackage;

import java.util.concurrent.*;

public class ThreadPool {

    public static void main(String[] args) {
        /**
         * 创建指定范围大小的线程池(4 - 10)
         */
        ExecutorService executorService = new ThreadPoolExecutor(4, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue<>());

        /**
         * 可以反复执行的线程池
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        /**
         * 延迟一秒后执行一次
         */
        scheduledExecutorService.schedule(() ->{}, 1, TimeUnit.SECONDS);
        /**
         * 2秒后开始执行任务，每3秒执行一次
         * 每三秒执行一次，不论任务执行多长时间
         */
        scheduledExecutorService.scheduleAtFixedRate(() ->{}, 2, 3, TimeUnit.SECONDS);
        /**
         * 2秒后开始执行任务，间隔3秒执行一次
         * 上一个任务完成后，间隔三秒执行下一个任务
         */
        scheduledExecutorService.scheduleWithFixedDelay(() ->{}, 2, 3, TimeUnit.SECONDS);
    }

}

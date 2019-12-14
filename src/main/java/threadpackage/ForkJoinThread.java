/**
 * FileName: ForkJoinThread
 * Author: xiaoyi
 * Description:    自动拆分线程
 * Date:   2019/12/1417:10
 */

package threadpackage;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinPool 可以将一个线程分裂为多个小线程完成。
 * ForkJoinTask object需继承RecursiveTask并实现compute方法，在compute方法中，定义线程分裂的条件。
 */

public class ForkJoinThread {

    public static void main(String[] args) {
        Random random = new Random();
        long[] array = new long[2000];
        long sum = 0;
        for(int i=0;i<array.length;i++)
        {
            array[i] = random.nextInt();
            sum += array[i];
        }
        System.out.println("sum：" + sum);
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = ForkJoinPool.commonPool().invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
    }

}

class SumTask extends RecursiveTask<Long>
{

    static final int THRESHOLD = 500;
    long[] array;
    int start;
    int end;

    SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if(end - start < THRESHOLD)
        {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += this.array[i];
                // 故意放慢计算速度:
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            }
            return sum;
        }
        int middle = (end + start) / 2;
        System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
        SumTask sumTask1 = new SumTask(this.array, start, middle);
        SumTask sumTask2 = new SumTask(this.array, middle, end);

        /**
        并行执行两个线程
         */
        invokeAll(sumTask1, sumTask2);

        long sum1 = sumTask1.join();
        long sum2 = sumTask2.join();
        long result = sum1 + sum2;
        System.out.println("result = " + sum1 + " + " + sum2 + " ==> " + result);
        return result;
    }
}

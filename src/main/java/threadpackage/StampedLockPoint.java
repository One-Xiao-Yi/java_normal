/**
 * FileName: StampedLockPoint
 * Author: xiaoyi
 * Description:    乐观读写锁
 * Date:   2019/12/1316:59
 */

package threadpackage;

import java.util.concurrent.locks.StampedLock;

public class StampedLockPoint {

    /**
     * StampedLock 读写锁，与ReadWriteLock类似。
     * 但ReadWriteLock在使用时，当有读操作时，写操作需等待读操作结束后，才能进行写操作。(悲观锁：总是认为会有写操作影响读操作)
     * 而StampedLock，在有读操作时，也可进行写操作。（乐观锁：总是认为没有写操作影响读操作）
     * 因为读取时可能进行写入操作，所以在读取时要进行检测，检测是否有写入操作进行，如果有，则获取悲观锁，再次进行读取。
     *
     * stamp 版本号，当没有其他锁操作时，版本号不变，否则版本号改变，以此判断是否有其他操作。
     *
     * StampedLock 是不可重入锁，一个线程不能重复获取同一个锁
     */
    private final StampedLock lock = new StampedLock();

    private double x;
    private double y;

    public void move(double deltaX, double deltaY)
    {
        long stamp = lock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        }finally {
            lock.unlockWrite(stamp);
        }
    }

    public double distanceFromOrigin()
    {
        /**
         * 获取乐观锁
         */
        long stamp = lock.tryOptimisticRead();

        double currentX = x;
        double currentY = y;

        /**
         * 检查乐观锁后，是否有写操作
         * validate 检查锁的版本号是否有改变
         */
        if(!lock.validate(stamp))
        {
            /**
             * 获取悲观锁
             */
            stamp = lock.readLock();
            try {
                currentX = x;
                currentY = y;
            }finally {
                lock.unlockRead(stamp);
            }
        }

        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

}

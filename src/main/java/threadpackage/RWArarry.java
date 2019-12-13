/**
 * FileName: RWArarry
 * Author: xiaoyi
 * Description:    读写锁实例
 * Date:   2019/12/1316:30
 */

package threadpackage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWArarry {

    /**
    ReadWriteLock 当没有写入操作时，可以多个线程同时进行读取操作，当有写入操作时，所有读取操作等待。
     */
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    private String[] counts = new String[10];

    public void inc(int index, String s)
    {
        if(index < counts.length && index >= 0)
        {
            writeLock.lock();
            try {
                counts[index] = s;
            }finally {
                writeLock.unlock();
            }
        }
    }

    public String get(int index)
    {
        readLock.lock();
        try {
            return counts[index];
        }finally {
            readLock.unlock();
        }
    }

}

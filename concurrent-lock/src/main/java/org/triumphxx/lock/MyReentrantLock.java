package org.triumphxx.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author:triumphxx
 * @Date:2021/4/18
 * @Time:8:30 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
public class MyReentrantLock implements Lock {

    private static class Sync extends AbstractQueuedSynchronizer {

        /**
         * 获取锁
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
            //获取锁状态信号量,0 表示无锁，否则有锁
            int state = getState();
            //第一次加锁
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
            }
            //如果当前线程和占用锁线程一直，表示线程重入
            if (Thread.currentThread() == getExclusiveOwnerThread()) {
                compareAndSetState(state, state + 1);
                return true;
            }
            //表明这个线程需要加入队列中进行等待
            return false;
        }

        /**
         * 释放锁,每次只有一个线程会进入到这个方法中
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
            int state = getState();
            setState(state - 1);
            if (getState() == 0) {
                setExclusiveOwnerThread(null);
            }
            return true;
        }

        /**
         * 锁释放被占用
         * getState > 0 表示被占用，否则没有被占用
         *
         * @return
         */
        @Override
        protected boolean isHeldExclusively() {
            return getState() > 0;
        }
    }


    Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return tryLock();
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}

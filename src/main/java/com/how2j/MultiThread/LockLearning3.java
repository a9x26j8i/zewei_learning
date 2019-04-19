package com.how2j.MultiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.how2j.MultiThread.LockLearning.log;

public class LockLearning3 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread t1 = new Thread(){
            @Override
            public void run(){
                try {
                    log("start and tries to get lock");
                    lock.lock();
                    log("got the lock and do 5s");
                    Thread.sleep(3000);
                    log("finished");
                    condition.await();
                    log("got the lock again and do 5s");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    log("finally unlock");
                    lock.unlock();
                }

            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run(){
                try {
                    log("try to get the lock");
                    lock.lock();
                    log("got the lock and sleep 5s");
                    Thread.sleep(3000);
                    log("start to signal");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    condition.signal();
                    lock.unlock();
                }
            }
        };

        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}

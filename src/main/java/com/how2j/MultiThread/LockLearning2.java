package com.how2j.MultiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.how2j.MultiThread.LockLearning.log;

public class LockLearning2 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread t1 = new Thread() {
            @Override
            public void run(){
                boolean gotLock = false;
                try {
                    gotLock = lock.tryLock(1, TimeUnit.SECONDS);

                    if (gotLock) {
                        log("got the lock!");
                        Thread.sleep(1000);
                    } else {
                        System.out.println("1s passed, " + Thread.currentThread().getName() + " gives up.");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (gotLock) {

                        lock.unlock();
                    }
                }
            }
        };
        t1.setName("thread1");
        t1.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread() {
            @Override
            public void run(){
                boolean gotLock = false;
                try {
                    gotLock = lock.tryLock(1, TimeUnit.SECONDS);
                    if (gotLock) {
                        log("got the lock!");
                        Thread.sleep(2000);
                    } else {
                        System.out.println("1s passed, " +Thread.currentThread().getName() + " gives up.");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally{
                    if (gotLock) {
                        lock.unlock();
                    }
                }
            }
        };
        t2.setName("thread2");
        t2.start();

    }
}

package com.how2j.MultiThread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockLearning {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    log("start and tries to get lock");
                    lock.lock();
                    log("got lock");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    log("released lock");
                    lock.unlock();
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run(){
                try {
                    log("start and tries to get lock");
                    lock.lock();
                    log("got lock");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    log("released lock");
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

    public static void log(String msg) {
        System.out.printf("%s %s %s %n",  now() , Thread.currentThread().getName() , msg);
    }

    public static String now() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

}

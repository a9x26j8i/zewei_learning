package com.how2j.MultiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread_DeadLock_tryLock {
    public static void main(String[] args) {
        final Hero ahri = new Hero();
        ahri.name = "ahri";
        Lock ahriLock = new ReentrantLock();
        Condition ahriCondition = ahriLock.newCondition();

        final Hero annie = new Hero();
        annie.name = "annie";
        Lock annieLock = new ReentrantLock();
        Condition annieCondition = annieLock.newCondition();

        final Hero gareen = new Hero();
        gareen.name = "gareen";
        Lock gareenLock = new ReentrantLock();
        Condition gareenCondition = gareenLock.newCondition();


        Thread thread1 = new Thread(){
            @Override
            public void run() {
                ahriLock.lock();
                System.out.println("t1 has ahri");
                boolean gotAnnieLock = false;
                try {
                    Thread.sleep(500);
                    System.out.println("t1 tries to got annie.");
                    gotAnnieLock = annieLock.tryLock(1, TimeUnit.SECONDS);
                    if (gotAnnieLock) {
                        System.out.println("got annie too!");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (gotAnnieLock) {
                        annieLock.unlock();
                    }
                }
                ahriLock.unlock();
            }

        };

        Thread thread2 = new Thread(){
            @Override
            public void run(){
                annieLock.lock();
                System.out.println("t2 has annie");
                boolean gotAhriLock = false;
                try {
                    Thread.sleep(500);
                    System.out.println("t2 tries to got ahri.");
                    gotAhriLock = ahriLock.tryLock(1, TimeUnit.SECONDS);
                    if (gotAhriLock) {
                        System.out.println("got ahri too!");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (gotAhriLock) {
                        ahriLock.unlock();
                    }
                }
                annieLock.unlock();
            }

        };

        thread2.start();
        thread1.start();
    }
}

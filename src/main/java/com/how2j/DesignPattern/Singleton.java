package com.how2j.DesignPattern;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Singleton {
    public static void main(String[] args){
        SingleTimer timer = SingleTimer.getInstance();
        Thread t1 = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 10000; i++) {
                    timer.n.getAndAdd(10);
                    System.out.println(timer.n);
                    System.out.println("manyidian");
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 10000; i++) {
                    timer.n.getAndAdd(-10);
                }
            }
        };
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result:" + timer.n);
    }

}

class SingleTimer {
    public static SingleTimer instance;
    public AtomicLong n = new AtomicLong();
    private SingleTimer(){}
    public static SingleTimer getInstance(){
        if (instance == null) {
            synchronized (SingleTimer.class) {
                if (instance == null) {
                    instance = new SingleTimer();
                }
            }
        }
        return instance;
    }

    public void start(){
        n.set(System.currentTimeMillis());
    }

    public Long lap(){
        Long result = System.currentTimeMillis() - n.get();
        n.set(System.currentTimeMillis());
        return result;
    }
}

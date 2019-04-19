package com.zewei.utils;

import java.util.concurrent.atomic.AtomicLong;

public class SingleTimer {
    public static volatile SingleTimer instance;
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
        System.out.println(result);
        return result;
    }
}
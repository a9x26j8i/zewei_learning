package com.how2j.MultiThread;

public class TestThreadLocals {
    public static void main(String[] args) {

        ThreadLocal<String> localString = new ThreadLocal<>();

        Thread t1 = new Thread(){
            @Override
            public void run(){
                localString.set("only t1");
                System.out.println("in t1:" + localString.get());
            }
        };

        t1.start();

        System.out.println("in t2: " + localString.get());
    }
}

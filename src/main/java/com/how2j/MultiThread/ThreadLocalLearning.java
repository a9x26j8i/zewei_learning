package com.how2j.MultiThread;

public class ThreadLocalLearning {
    ThreadLocal<Integer> localInteger = new ThreadLocal<>();
    public static void main(String[] args) {
        ThreadLocalLearning threadLocalLearning = new ThreadLocalLearning();
        threadLocalLearning.test();
    }

    public void test(){
        Thread t1 = new Thread(){
            @Override
            public void run(){
                localInteger.set(1);
                System.out.println("in t1:" + localInteger.get());
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run(){
                localInteger.set(2);
                System.out.println("in t2:" + localInteger.get());
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

        System.out.println(localInteger.get());
    }
}

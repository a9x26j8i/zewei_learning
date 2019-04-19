package com.how2j.MultiThread;

public class TestThread2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run(){
                int seconds = 0;
                while(true) {
                    try {
                        System.out.println("已经进行了:" + seconds +"s");
                        Thread.sleep(1000);
                        seconds++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.setDaemon(true);
        t1.start();
    }

}

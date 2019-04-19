package com.how2j.MultiThread;

public class TestThread_DeadLock {
    public static void main(String[] args) {
        final Hero ahri = new Hero();
        ahri.name = "ahri";
        final Hero annie = new Hero();
        annie.name = "annie";
        final Hero gareen = new Hero();
        gareen.name = "gareen";

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                synchronized (ahri) {
                    System.out.println("t1 has ahri, tries to get annie");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (annie) {
                        System.out.println("t1 got annie");
                    }
                }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run(){
                synchronized (annie) {
                    System.out.println("t2 has annie, tries to get gareen");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (gareen) {
                        System.out.println("t2 got gareen");
                    }
                }
            }
        };

        Thread thread3 = new Thread() {
            @Override
            public void run(){
                synchronized(gareen) {
                    System.out.println("t3 has gareen, tries to get ahri");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (ahri) {
                        System.out.println("t3 got ahri");
                    }
                }
            }
        };

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

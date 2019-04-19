package com.how2j.MultiThread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestThread5 {
    public static void main(String[] args) {
        final Car obj = new Car();
        StringBuffer sb = new StringBuffer();
        Thread t1 = new Thread() {
            @Override
            public void run(){
                System.out.println(now() + "t1 is running");
                System.out.println(now() + this.getName() + " tries to grab the obj");
                synchronized (obj) {
                    System.out.println(now() + this.getName() + " grabbed the obj");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(now() + this.getName() + " released the obj.");
                }
            }
        };
        t1.setName(" t1");
        Thread t2 = new Thread() {
            @Override
            public void run(){
                System.out.println(now() + "t2 is running");
                System.out.println(now() + this.getName() + " tries to grab the obj");
                synchronized (obj) {
                    System.out.println(now() + this.getName() + " grabbed the obj");
                    obj.field++;
                    System.out.println(obj.field);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(now() + this.getName() + " released the obj.");
                }
            }
        };
        t2.setName(" t2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(obj.field);
    }

    private static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date()).toString();
    }
}

class Car {
    public int field = 1;
}

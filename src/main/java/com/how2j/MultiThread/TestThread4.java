package com.how2j.MultiThread;

import java.util.ArrayList;
import java.util.Collections;

public class TestThread4 {
    public static void main(String[] args) {
        boolean yizhi = true;
        while(yizhi){
            Hero gareen = new Hero();
            gareen.name = "盖伦";
            gareen.hp = 10000;
            Thread[] addThread = new Thread[1000];
            Thread[] reduceThread = new Thread[1000];
            for (int i = 0; i< 1000; i++) {
                addThread[i] = new Recover(gareen);
                reduceThread[i] = new Hurt(gareen);
            }

            for (int i = 0; i<1000; i++) {
                addThread[i].start();
                reduceThread[i].start();
            }

            for (Thread t : addThread) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (Thread t : reduceThread) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            yizhi = gareen.hp == 10000.0;
            if (!yizhi) {
                System.out.println(gareen.hp);
            }
        }


    }

}

class Recover extends Thread {
    Hero h;
    public Recover(Hero h) {
        this.h = h;
    }
    @Override
    public void run(){
        h.recover();
    }
}

class Hurt extends Thread{
    Hero h;

    public Hurt(Hero h) {
        this.h = h;
    }
    @Override
    public void run(){
        h.hurt();
    }

}
package com.how2j.MultiThread;

public class Multithread_Interact {
    public static void main(String[] args) {
        final Hero gareen = new Hero();
        gareen.name = "gareen";
        gareen.hp = 100;
        Thread thread1 = new Hurt2(gareen);
        Thread thread2 = new Recover2(gareen);
        Thread[] recovers = new Thread[3];
        Thread[] hurts = new Thread[5];
        for (int i = 0; i < 2; i++) {
            recovers[i] = new Recover2(gareen);
        }
        for (int i = 0; i < 5; i++) {
            hurts[i] = new Hurt2(gareen);
        }

        for (int i = 0; i < 7; i++) {
            if (i/2 == 0) {
                recovers[i].start();
            } else {
                hurts[i - 2].start();
            }
        }
    }

}

class Recover2 extends Thread{
    public Hero h;
    public Recover2(Hero h) {
        this.h = h;
    }
    @Override
    public void run(){
        while(true) {
            h.recover();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Hurt2 extends Thread {
    public Hero h;
    public Hurt2(Hero h) {
        this.h = h;
    }
    @Override
    public void run(){
        while(true) {
            h.hurt();
            System.out.println("decrease");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


package com.how2j.MultiThread;

public class Battle implements Runnable {
    private final Hero h1;
    private final Hero h2;
    public Battle(Hero h1, Hero h2) {
        this.h1 = h1;
        this.h2 = h2;
    }

    @Override
    public void run(){
        while(!h2.isDead()) {
            h1.attackHero(h2);
        }
    }
}

package com.how2j.MultiThread;

public class TestThread {

    public static void main(String[] args) {

        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 1;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 1;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 1;

        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 1;

        //盖伦攻击提莫
        Thread t1 = new Thread(){
            @Override
            public void run(){
                while(!teemo.isDead()) {
                    gareen.attackHero(teemo);
                }
            }
        };
        //赏金猎人攻击盲僧
        Thread t2 = new Thread(){
            @Override
            public void run(){
                while(!leesin.isDead()) {
                    bh.attackHero(leesin);
                }
            }
        };
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }

}

package com.how2j.MultiThread;

public class Hero{
    public String name;
    public float hp;
    public final float MAX_HP = 300;
    public int damage;

    public void attackHero(Hero h) {
//        try {
//            //为了表示攻击需要时间，每次攻击暂停1000毫秒
//            Thread.sleep(300);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);

        if(h.isDead())
            System.out.println(h.name +"死了！");
    }

    //回血
    public synchronized void recover(){
        System.out.println("血量:" + hp);
        if(hp == MAX_HP) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            hp=hp+1;
        }
    }

    //掉血
    public synchronized void hurt(){
        if (hp == 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (hp == 300) {
            notifyAll();
        }
        hp=hp-1;
        System.out.println("血量:" + hp);
    }

    public boolean isDead() {
        return hp <= 0 ? true:false;
    }


}

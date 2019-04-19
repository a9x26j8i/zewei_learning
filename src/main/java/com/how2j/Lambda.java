package com.how2j;

import java.util.*;

public class Lambda {
    public static void main(String[] args) {
        List<Hero> heros = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero" + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("after init:");
        System.out.println(heros);
        System.out.println("hp > 100 && damage < 50");

        //把函数作为参数斤进行传递
        filter(heros, h-> (h.hp > 100 && h.damage < 50));
    }

    private static void filter(List<Hero> heros, HeroChecker checker) {
        for (Hero hero : heros) {
            if(checker.yy(hero)) {
                System.out.println(hero);
            }
        }
    }

}

interface HeroChecker {
    public boolean yy(Hero h);
}

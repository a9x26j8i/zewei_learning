package com.zewei.java;

import java.util.ArrayList;
import java.util.LinkedList;

public class B extends A{
    public static void main(String[] args) {
        A b = new B();
        Character c = 'c';
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println(c.equals('c'));
    }

    public void print(){
        System.out.println("I am b");
    }

    public int print(int a) {
        return 1;
    }

}

abstract class A{
    protected int pp;
    public A() {
        pp = -1;
    }

    public void print() {
        System.out.println("I am a");
    }
}

interface Test{
    void check();
}
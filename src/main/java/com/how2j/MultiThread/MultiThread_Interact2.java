package com.how2j.MultiThread;

import java.util.*;

public class MultiThread_Interact2 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Random r = new Random();
        Thread[] prodThreads = new Thread[2];
        Thread[] consThreads = new Thread[3];
        for (int i = 0; i < 2; i++) {
            prodThreads[i] = new ProducerThread(stack, i);
            prodThreads[i].start();
            prodThreads[i].setName("prod" + i);
        }
        for (int i = 0; i < 3; i++) {
            consThreads[i] = new ConsumerThread(stack, i);
            consThreads[i].start();
            consThreads[i].setName("cons" + i);
        }
    }
}

class ProducerThread extends Thread {
    Stack<Integer> stack;
    Random r = new Random();
    int i;
    public ProducerThread(Stack<Integer> stack, int i){
        this.stack = stack;
        this.i = i;
    }
    @Override
    public void run(){
        while(true) {
            int num = r.nextInt(10);
            stack.push(num);
            System.out.println("producer" + i + " pushed: " + num + " size: " + stack.size());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class ConsumerThread extends Thread {
    Stack<Integer> stack;
    Random r = new Random();
    int i;
    public ConsumerThread(Stack<Integer> stack, int i){
        this.stack = stack;
        this.i = i;
    }
    @Override
    public void run(){
        while(true) {
            int num = stack.pop();
            System.out.println("consumer" + i + " popped: " + num + " size: " + stack.size());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Stack<T> {
    List<T> list;

    public Stack() {
        list = Collections.synchronizedList(new ArrayList<T>());
    }
    public synchronized void push(T t) {
        while (list.size() == 200) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        notify();
    }
    public synchronized T pop() {
        while (list.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = list.remove(list.size() - 1);
        notify();
        return t;
    }

    public synchronized int size(){
        return list.size();
    }

}


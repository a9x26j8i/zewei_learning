package com.how2j.MultiThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThread_Interact3 {
    public static void main(String[] args) {
        Stack2<Integer> stack = new Stack2<>();
        Random r = new Random();
        Thread[] prodThreads2 = new Thread[2];
        Thread[] consThreads2 = new Thread[3];
        for (int i = 0; i < 2; i++) {
            prodThreads2[i] = new ProducerThread2(stack, i);
            prodThreads2[i].start();
            prodThreads2[i].setName("prod" + i);
        }
        for (int i = 0; i < 3; i++) {
            consThreads2[i] = new ConsumerThread2(stack, i);
            consThreads2[i].start();
            consThreads2[i].setName("cons" + i);
        }
    }
}

class ProducerThread2 extends Thread {
    Stack2<Integer> stack;
    Random r = new Random();
    int i;
    public ProducerThread2(Stack2<Integer> stack, int i){
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

class ConsumerThread2 extends Thread {
    Stack2<Integer> stack;
    Random r = new Random();
    int i;
    public ConsumerThread2(Stack2<Integer> stack, int i){
        this.stack = stack;
        this.i = i;
    }
    @Override
    public void run(){
        while(true) {
            int num = stack.pop();
            System.out.println("consumer" + i + " popped: " + num + " size: " + stack.size());
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Stack2<T> {
    List<T> list;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public Stack2() {
        list = Collections.synchronizedList(new ArrayList<T>());
    }
    public void push(T t) {
        lock.lock();
        while (list.size() == 200) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        condition.signal();
        lock.unlock();
    }
    public T pop() {
        lock.lock();
        while (list.size() == 0) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = list.remove(list.size() - 1);
        condition.signal();
        lock.unlock();
        return t;
    }

    public int size(){
        lock.lock();
        int size = list.size();
        lock.unlock();
        return size;
    }

}


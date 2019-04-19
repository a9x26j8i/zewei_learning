package com.how2j.MultiThread;

public class TestThreadPool {
    public static void main(String[] args){
        ThreadPool pool = new ThreadPool();
        int sleep = 1000;

        while(true) {
            Runnable runnable = new Runnable(){
                @Override
                public void run(){
                    System.out.println("interface can be instantiated as anonymous instance");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            try {
                Thread.sleep(sleep);
                if (sleep > 200) {
                    sleep -= 100;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            pool.add(runnable);
        }

    }
}

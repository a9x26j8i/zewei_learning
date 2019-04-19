package com.how2j.MultiThread;

import java.util.ArrayList;

public class ThreadPool {
    private final int SIZE = 10;
    ArrayList<Runnable> tasks = new ArrayList<>();
    public ThreadPool() {
        for (int i = 0; i < SIZE; i++) {
            TaskConsumeThread taskConsumeThread = new TaskConsumeThread("consumerThread" + i);
            taskConsumeThread.start();
        }

    }

    public void add(Runnable task) {
        synchronized (tasks) {
            tasks.add(task);
            tasks.notifyAll();
        }
    }

    class TaskConsumeThread extends Thread {
        Runnable targetJob;

        public TaskConsumeThread(String name) {
            super(name);
        }

        @Override
        public void run(){
            System.out.println("启动 " + this.getName());
            while(true) {
                synchronized (tasks) {
                    while(tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    targetJob = tasks.remove(tasks.size() - 1);
                    tasks.notifyAll();
                }
                System.out.println(this.getName() + "已获取任务，执行中");
                targetJob.run();
            }
        }
    }
}



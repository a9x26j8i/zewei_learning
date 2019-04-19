package com.how2j.MultiThread;

public class TestThread3 {
    public static void main(String[] args) {
        Fight fight = new Fight();
        new Thread(fight).start();
    }
}

class Fight implements Runnable {
    private int count = 1;
    @Override
    public void run(){
        try {
            while(true) {
                System.out.println("波动拳第" + count + "发");
                Thread.sleep(1000);
                count++;
                if (count == 4) {
                    Charge charge = new Charge();
                    Thread chargeThread = new Thread(charge);
                    chargeThread.start();
                    chargeThread.join();
                    count = 1;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Charge implements Runnable {
    @Override
    public void run(){
        System.out.println("charge for 5s");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

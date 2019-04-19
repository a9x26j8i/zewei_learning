package com.how2j.MultiThread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool2 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        File folder = new File("C:\\Users\\DELL\\Desktop\\CSCI\\CSCI571");
        File[] files = folder.listFiles();

        for (File file : files) {
            if (file.getName().contains(".java")) {
                threadPool.execute(new Runnable(){
                    @Override
                    public void run() {
                        try {
                            char[] all = new char[(int)file.length()];
                            FileReader fr = new FileReader(file);
                            fr.read(all);
                            String s = new String(all);
                            System.out.println(file.getName()+"--------------");
                            System.out.println(s);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                });
            }
        }
    }
}

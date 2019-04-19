package com.zewei.java;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class References {
    public static void main(String[] args) {
        SoftReference<ArrayList<Integer>> sr = new SoftReference(new ArrayList<Integer>());
        sr.get().add(1);
        sr.get().add(2);
        sr.get().add(3);
        System.out.println(sr.get().toString());

//        ThreadPoolExecutor
//        Executors.newCachedThreadPool()
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        
    }
}

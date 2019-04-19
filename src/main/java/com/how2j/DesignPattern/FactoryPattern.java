package com.how2j.DesignPattern;

import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadFactory;

public class FactoryPattern {
    public static void main(String[] args){
        try {
            IProduct product = Factory.getProduct("ProductB");
            product.work();
            ThreadFactory threadFactory = new ThreadFactory() {
                @Override
                public Thread newThread(final Runnable r) {
                    return new Thread(){
                        @Override
                        public void run(){
                            r.run();
                        }

                    };
                }
            };
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }


}

class Factory{
    public static String packageName = "com.how2j.DesignPattern";
    public static IProduct product = null;
    public static IProduct getProduct(String productType) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (productType.equals("ProductA")) {
            product =  (IProduct) Class.forName(packageName + ".ProductA").newInstance();
        } else {
            product = (IProduct) Class.forName(packageName + ".ProductB").newInstance();
        }
        return product;
    }
}

interface IProduct {
    void work();
}

class ProductA implements IProduct {
    @Override
    public void work() {
        System.out.println("productA for you");
    }
}

class ProductB implements IProduct {
    @Override
    public void work() {
        System.out.println("productB for you");
    }
}
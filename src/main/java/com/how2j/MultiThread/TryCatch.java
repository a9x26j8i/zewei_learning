package com.how2j.MultiThread;

public class TryCatch {
    public static void main(String[] args){
        test();
    }

    public static void test(){
        try{
            throw new Exception("a");
        } catch(Exception e) {
            return;
        } finally {
            System.out.println("wo haishi bei zhixingle ya.");
        }
    }

}



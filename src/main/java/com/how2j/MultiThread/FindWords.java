package com.how2j.MultiThread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FindWords extends Thread {
    private File file;
    public FindWords (File file) {
        this.file = file;
    }
    @Override
    public void run(){
        try {
            FileReader fr = new FileReader(file);
            char[] all = new char[(int)file.length()];
            fr.read(all);
            String s = new String(all);
            System.out.print(s.contains("new"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

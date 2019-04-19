package com.how2j.MultiThread;

import java.io.File;
import java.util.Arrays;

public class FindFile {
    public static void main(String[] args) {
        File targetFile = new File("C:\\Users\\DELL\\Desktop\\CSCI\\CSCI571");
        for (File file : targetFile.listFiles()) {
            if (file.getName().contains(".java")) {
                Thread findWords = new FindWords(file);
                findWords.start();
            }
        }
    }
}

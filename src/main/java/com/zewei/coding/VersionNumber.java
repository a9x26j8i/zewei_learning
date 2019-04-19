package com.zewei.coding;

import java.util.Comparator;

public class VersionNumber {

}

class SortByVersion implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] array1 = o1.split(".");
        String[] array2 = o2.split(".");
        int n = array1.length;
        int m = array2.length;
        int max = Math.max(n, m);
        int i = 0;
        int num1 = 0;
        int num2 = 0;
        while(i < max) {
            if (i >= n) {
                num1 = 0;
            } else {
                num1 = Integer.valueOf(array1[i]);
            }
            if (i >= m) {
                num2 = 0;
            } else {
                num2 = Integer.valueOf(array2[i]);
            }

            if (num1 < num2) {
                return -1;
            } else if (num1 > num2){
                return 1;
            }
            i++;
        }
        return 0;
    }
}

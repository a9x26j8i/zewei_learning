package com.zewei.coding;

import java.util.Arrays;
import com.zewei.utils.TreeNode;

public class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();

        String str = "abbcccbaacbb";
        int k = 3;

        System.out.println(s.findCount(str, k));
        System.out.println(s.countKDistinct(str, k));
    }

    //Amazon OA2 k-1 distinct in k
    private int countK1Distinct(String str, int k) {
        int[] charToFreqMap = new int[26];
        int res = 0;
        int distinct = 0;
        //make window
        for (int i = 0; i < k; i++) {
            charToFreqMap[str.charAt(i) - 'a']++;
            if (charToFreqMap[str.charAt(i) - 'a'] == 1) {
                distinct++;
            }
            System.out.println(distinct);
        }
        if(distinct == k - 1) {
            res++;
        }
        //slide window
        for (int i = k; i < str.length(); i++) {
            charToFreqMap[str.charAt(i) - 'a']++;
            if (charToFreqMap[str.charAt(i) - 'a'] == 1) {
                distinct++;
            }
            charToFreqMap[str.charAt(i - k) - 'a']--;
            if (charToFreqMap[str.charAt(i - k) - 'a'] == 0) {
                distinct--;
            }
            System.out.println("jinlaile, distinct:" + distinct);
            if(distinct == k - 1) {
                res++;
                System.out.println(i);
            }
        }
        return res;
    }
    //Amazon OA2 k in substring
    private int countKDistinct(String str, int k) {
        int[] charToFreqMap = new int[26];
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            int distinct = 0;
            Arrays.fill(charToFreqMap, 0);
            for (int j = i; j >= 0; j--) {
                //update distinct
                charToFreqMap[str.charAt(j) - 'a']++;
                if (charToFreqMap[str.charAt(j) - 'a'] == 1) {
                    distinct++;
                }
                //count
                if (distinct == k) {
                    res++;
                } else if (distinct > k) {
                    break;
                }

            }
        }
        return res;
    }
    //AMAZON OA2
    private int countKSliding(String str, int k) {
        int n = str.length();
        int res = 0;
        int start = 0;
        int end = 0;
        int distinct = 0;
        int[] charToFreqMap = new int[26];
        //make window
        while(end < n && distinct != k) {
            char c = str.charAt(end);
            if (charToFreqMap[c - 'a'] == 0) {
                distinct++;
            }
            charToFreqMap[c - 'a']++;
        }
        res++;
        //sliding window
        while(end < n) {

        }
        return res;
    }

    public int findCount(String str, int k){
        int[] hash = new int[256];
        int result = 0;
        int right = 0, left = 0, distinct = 0;
        while(right < str.length()){
            if(hash[str.charAt(right)] == 0)
                distinct++;
            hash[str.charAt(right)] ++;
            right++;

            if(distinct == k)
            {
                result++;
                if(hash[str.charAt(left)] == 1)
                    distinct--;
                left++;
            }
        }
        return result;
    }

    //amazon OA1
    private int[] manchester(int[] arr) {
        boolean result;
        int[] output = new int[arr.length];
        if(arr == null || arr.length == 0 || arr.length == 1) {
            return output;
        }

        for (int i= arr.length - 1; i > 0; i--) {
            result = (arr[i] != arr[i - 1]);
            output[i] = result ? 1 : 0;
        }

        return output;
    }

    private void print(int row) {
        int x = 1;
        for (int i = 1; i <= row; i++) {
            for (int j = i; j > 0; j--)
                System.out.print(x + "" + x);

            System.out.println("");
        }
    }

    private void sort(){
        int[] arr = new int[] {4,7,2,7,9,23,1,6};
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                int temp = arr[i];
                int j = i;
                while (j > 0 && arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = temp;
            }
        }
        printArray(arr);
    }

    private void stringToNumber(String s){
        s = s.toLowerCase();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                int k = s.charAt(i) - 'a';
                System.out.print(k + 1  + " ");
            } else if (s.charAt(i) == ';') {
                System.out.println(s.charAt(i));
            } else {
                System.out.print(s.charAt(i) + " ");
            }

        }
    }

    private void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}

package com.zewei.coding;

public class LongestPalindromicSubstring {
    //LC214 LC647
    public static void main(String[] args) {
        LongestPalindromicSubstring s = new LongestPalindromicSubstring();
        String str = "fabzbaqabbe";
        System.out.println(s.longestPalindromicSubstring(str));
    }

    public String longestPalindromicSubstring(String s) {
        int n = s.length();
        int longestStart = 0;
        int longestEnd = 0;
        //for odd
        for (int i = 0; i < n; i++) {
            int start = i;
            int end = i;
            while(start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
                if (end - start + 1 >= longestEnd - longestStart + 1) {
                    longestEnd = end;
                    longestStart = start;
                }
                start--;
                end++;
            }
        }
        //for even
        for (int i = 0; i < n - 1; i++) {
            int start = i;
            int end = i + 1;
            while(start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
                if (end - start + 1 >= longestEnd - longestStart + 1) {
                    longestEnd = end;
                    longestStart = start;
                }
                start--;
                end++;
            }
        }
        return s.substring(longestStart, longestEnd + 1);
    }
}

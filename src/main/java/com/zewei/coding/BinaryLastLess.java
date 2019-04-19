package com.zewei.coding;

public class BinaryLastLess {
    public static void main(String[] args) {
        int[] array = {1,3,5,9,12,15};
        System.out.println(array[binarySearchFirstBigger(array, 12)]);
    }

    private static int binarySearchLastLess(int[] array, int target) {
        int n = array.length;
        int start = 0;
        int end = n - 1;
        while(start <= end) {
            int mid = (start + end)/2;
            if (array[mid] <= target) {//start 倾向于多走
                start = mid + 1;
            } else { // target < array[mid]
                end = mid - 1;
            }
        }
        if (start == 0) {
            return -1;
        } else {
            return start - 1;
        }

    }

    private static int binarySearchFirstBigger(int[] array, int target) {
        int n = array.length;
        int start = 0;
        int end = n - 1;
        while(start <= end) {
            int mid = (start + end)/2;
            if (array[mid] < target) {
                start = mid + 1;
            } else {// target >= array[i] //end 倾向于多走
                end = mid - 1;
            }
        }
        if (end == n - 1) {
            return -1;
        } else {
            return end + 1;
        }
    }
}

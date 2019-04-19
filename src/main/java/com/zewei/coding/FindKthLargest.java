package com.zewei.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKthLargest {
    public static void main(String[] args) {
//        int[] nums = {3,2,1,5,6,4};
//        int k = 2;
//
//        System.out.println(findKthLargest(nums, k));
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Integer[] a = new Integer[arrayList.size()];
        arrayList.toArray(a);

        System.out.println(Arrays.toString(a));
    }

    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private static int quickSelect(int[] nums, int start, int end, int k) {
        int pivI = partition(nums, start, end);
        if (pivI == k - 1) {
            return nums[pivI];
        }

        int result = -1;
        if(pivI < k - 1) {
            result = quickSelect(nums, pivI + 1, end, k);
        } else {
            result = quickSelect(nums, start, pivI - 1, k);
        }
        return result;
    }

    private static int partition(int[] nums, int start, int end) {

        int pivot = nums[end];
        int storeI = start; //storeI从startIndex开始
        for (int i = start; i < end; i++) { //从startindex开始扫描
            if (nums[i] > pivot) {
                swap(nums, i, storeI);
                storeI++;
            }
        }
        swap(nums, storeI, end);

        return storeI;
    }

    private static void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

}

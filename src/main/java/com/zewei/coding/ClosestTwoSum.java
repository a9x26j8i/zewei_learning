package com.zewei.coding;

import java.util.Arrays;

public class ClosestTwoSum {
    public static void main(String[] args) {
        int[] array = new int[]{1,23,12,43,12,64,6,12,5};
        ClosestTwoSum s = new ClosestTwoSum();
        System.out.println(s.closestTwoSum(array, 15) + " : " + s.twoSumClosest(array, 15));
    }

    public int closestTwoSum(int[] array, int target) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            if (Math.abs(array[left] + array[right] - target) < res) {
                res = Math.abs(array[left] + array[right] - target);
            }

            if (array[left] + array[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return res;
    }

    public int twoSumClosest(int[] nums, int target) {
        // Write your code here

        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] < target) {
                min = Math.min(min, target - nums[left] - nums[right]);
                left++;
            }
            else {
                min = Math.min(min, nums[left] + nums[right] - target);
                right--;
            }
        }

        return min;
    }
}

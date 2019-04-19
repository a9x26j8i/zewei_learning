package com.zewei.coding;

import java.util.Arrays;

public class QuickSort_depracated {
    public static void main(String[] args) {
        int[] array = {2,4,2,74,1,10,2,3};
//        int[] array = {2,1,2,3};
//        int[] array = {6,7,1,2};
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = partition(array, start, end);

        quickSort(array, start, mid - 1);
        quickSort(array, mid + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int i = start + 1;
        int j= end;
        while(i < j) {
            while(i < j && array[j] >= pivot) {
                j--;
            }
            while (i < j && array[i] < pivot) {
                i++;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }
        if (array[j] < pivot) {
            array[start] = array[j];
            array[j] = pivot;
            System.out.println(Arrays.toString(array));
            return j;
        } else {
            System.out.println(Arrays.toString(array));
            return start;
        }

    }


}

package com.zewei.coding;

import com.zewei.utils.SingleTimer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuickSort2 {
    public static void main(String[] args) {
        SingleTimer timer = SingleTimer.getInstance();

        QuickSort2 q = new QuickSort2();
        int[] array =  q.randomArray(80);

        int[] array1 = Arrays.copyOf(array, array.length);
        int[] array2 = Arrays.copyOf(array, array.length);

        System.out.println(Arrays.toString(array));

        timer.start();
        q.insertionSort(array1);
        System.out.println(Arrays.toString(array1));
        timer.lap();

        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));
        timer.lap();
    }


    //425 245
    private void quickSort(int[] array, int start, int end) {
        //base case
        if (start >= end) {
            return;
        }
        //general case
        int pivot = array[end];
        int size = 0;
        for (int i = start; i < end; i++) {
            if (array[i] < pivot) {
                swap(array, start + size, i);
                size++;
            }
        }
        swap(array, start + size, end);

        quickSort(array, start, start + size - 1);
        quickSort(array, start + size + 1, end);
    }

    private List<Integer> mergeSort(int[] array, int start, int end) {
        //base case
        //conquer
        if (start == end) {
            List<Integer> result = new ArrayList<>();
            result.add(array[start]);
            return result;
        }
        //general case
        //divide
        int mid = (start + end) / 2;
        List<Integer> leftResult = mergeSort(array, start, mid);
        List<Integer> rightResult = mergeSort(array, mid + 1, end);
        //combine
        List<Integer> myResult = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i != leftResult.size() && j != rightResult.size()) {
            if (leftResult.get(i) < rightResult.get(j)) {
                myResult.add(leftResult.get(i));
                i++;
            } else {
                myResult.add(rightResult.get(j));
                j++;
            }
        }
        if (i != leftResult.size()) {
            for (; i < leftResult.size(); i++) {
                myResult.add(leftResult.get(i));
            }
        } else {
            for (; j < rightResult.size(); j++) {
                myResult.add(rightResult.get(j));
            }
        }

        return myResult;
    }

    private void binarySearch(){
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int target = 4;
        int i = 0;
        int j = array.length - 1;

        while(j - i + 1 > 1) {
            System.out.println(i + ":" + j);
            int mid = (i + j) / 2;
            if (target == array[mid]) {
                break;
            }

            if (target < array[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        System.out.println(array[i]);
    }

    private void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= n - 2 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private void selectionSort(int[] array) {
        int n = array.length;
        for (int size = 0; size < n - 1; size++) {
            int minIndex = size;
            for (int i = size; i < n; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            swap(array, size, minIndex);
        }
    }

    private void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int j = i;
            int temp = array[i + 1];
            while(j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    private int[] randomArray(int length) {
        List<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arrayList.add(random.nextInt(500));
        }
        int[] result = new int[arrayList.size()];
        for (int i = 0; i < length; i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }

}

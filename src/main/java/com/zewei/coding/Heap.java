package com.zewei.coding;

import java.util.ArrayList;
import java.util.Arrays;

public class Heap {
    private int[] heap;
    private int size;

    public Heap (int size, int[] array) {
        heap = array;
        this.size = size;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        Heap h = new Heap(10, a);
        h.heapify();
        h.remove();
        h.remove();
        h.remove();
        System.out.println(h);
    }

    private void heapify() {
        for (int i = (int)Math.floor((size - 1)/2); i >= 0; i--) {
            siftDown(i);
        }
    }

    public String toString(){
        return Arrays.toString(heap);
    }

//    private void insert(int x) {
//        heap[size] = x;
//        siftUp(size);
//        size++;
//    }

    public int remove() {
        int max = heap[0];
        delete(0);
        return max;
    }

    public void delete(int i) {
        heap[i] = heap[size - 1];
        size--;
        siftDown(i);
        siftUp(i);
    }

    private void siftUp(int i) {
        int parentIndex = (i - 1) / 2;
        if (i > 0 && heap[parentIndex] < heap[i]) {
            int temp = heap[parentIndex];
            heap[parentIndex] = heap[i];
            heap[i] = temp;
            siftUp(parentIndex);
        }
    }

    private void siftDown(int i) {
        int leftIndex = i * 2 + 1;
        int rightIndex = i * 2 + 2;
        int largerChildIndex = -1;
        if (rightIndex < size && heap[rightIndex] > heap[leftIndex]) {
            largerChildIndex = rightIndex;
        } else if (leftIndex < size){
            largerChildIndex = leftIndex;
        }

        if (largerChildIndex != -1
                && heap[largerChildIndex] > heap[i]) {
            int temp = heap[largerChildIndex];
            heap[largerChildIndex] = heap[i];
            heap[i] = temp;
            siftDown(largerChildIndex);
        }
    }
}
package com.zewei.coding;

import java.util.*;

public class HighestFive {
    public static void main(String[] args){
        int[][] result = {{1, 98},{1, 99},{1, 96}, {1,97}, {1,80}, {1, 77}, {1, 100}, {1, 87}, {1, 98},
                          {2, 69},{2, 56}, {2, 100}, {2,99}, {2, 76}, {2, 80}, {2, 100}, {2, 98}};
        Map<Integer, PriorityQueue<Integer>> idToGrades = new HashMap<>();

        for (int[] record : result) {
            PriorityQueue<Integer> pq = idToGrades.get(record[0]);
            if (pq == null) {
                pq = new PriorityQueue<>((o1, o2)->{return o1 - o2;});
                idToGrades.put(record[0], pq);
            }
            if (pq.size() == 5) {
                pq.poll();
            }
            pq.add(record[1]);
        }

        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : idToGrades.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }
}

class Record {
    int _score;
    int _id;
    public Record(int score, int id) {
        _score = score;
        _id = id;
    }
}

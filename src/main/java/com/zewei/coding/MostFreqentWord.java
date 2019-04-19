package com.zewei.coding;

import java.util.*;

public class MostFreqentWord {
    public static void main(String[] args) {
        String str = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favority food.";
        String[] exclude = new String[] {"and", "he", "the", "to", "is", "Jack", "Jill"};
        MostFreqentWord s = new MostFreqentWord();
        System.out.println(s.mostFreqentWord(str, exclude));
    }

    private ArrayList<String> mostFreqentWord(String str, String[] exclude){
        str = str.toLowerCase();
        String[] words = str.split("[^a-zA-Z]");
        System.out.println(Arrays.toString(words));
        Map<String, Integer> wordToFreqMap = new HashMap<>();
        Set<String> excludeWords = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        for (String e : exclude) {
            excludeWords.add(e.toLowerCase());
        }

        int highestFreq = 0;
        for (String word : words) {
            if (!excludeWords.contains(word)) {
                int freq = wordToFreqMap.getOrDefault(word, 0);
                freq += 1;
                wordToFreqMap.put(word, freq);
                if (freq > highestFreq) {
                    highestFreq = freq;
                }
            }
        }

        for (Map.Entry<String, Integer> entry : wordToFreqMap.entrySet()) {
            if (entry.getValue() == highestFreq) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}

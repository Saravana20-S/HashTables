package com.bridgelabz.hashtables;

import org.junit.Assert;
import org.junit.Test;
import java.util.LinkedHashSet;
import java.util.Set;

public class MyHashTableUC2Test {

    @Test
    public void givenALargeParagraph_WhenWordsAreAddedToHashTable_ShouldReturnWordFrequency() {
        String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";

        // Clean punctuation if any, convert to lowercase, and split by space
        String[] words = paragraph.toLowerCase().split("\\s+");

        // Initialize Hash Table with 20 buckets to evenly distribute words
        MyHashTable<String, Integer> myHashTable = new MyHashTable<>(20);

        // Process each word to compute and update frequencies
        for (String word : words) {
            Integer value = myHashTable.get(word);
            if (value == null) {
                value = 1;
            } else {
                value = value + 1;
            }
            myHashTable.add(word, value);
        }

        // Use a Set to print unique words and visually verify frequencies
        System.out.println("--- Large Paragraph Word Frequencies ---");
        Set<String> uniqueWords = new LinkedHashSet<>();
        for (String word : words) {
            if (uniqueWords.add(word)) {
                System.out.println("'" + word + "' appears -> " + myHashTable.get(word) + " time(s)");
            }
        }

        // Assert/Verify specific frequencies requested by the problem logic
        Integer paranoidFrequency = myHashTable.get("paranoid");
        Integer areFrequency = myHashTable.get("are");
        Integer becauseFrequency = myHashTable.get("because");

        Assert.assertEquals(Integer.valueOf(3), paranoidFrequency);
        Assert.assertEquals(Integer.valueOf(2), areFrequency);
        Assert.assertEquals(Integer.valueOf(2), becauseFrequency);
    }
}
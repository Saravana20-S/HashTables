package com.bridgelabz.hashtables;

import org.junit.Assert;
import org.junit.Test;

public class MyHashTableUC1Test {

    @Test
    public void givenASentence_WhenWordsAreAddedToHashTable_ShouldReturnWordFrequency() {
        String sentence = "To be or not to be";

        // Convert to lowercase and split by spaces to isolate individual words
        String[] words = sentence.toLowerCase().split(" ");

        MyHashTable<String, Integer> myHashTable = new MyHashTable<>();

        // Loop through the words array and calculate frequencies dynamically
        for (String word : words) {
            Integer value = myHashTable.get(word);
            if (value == null) {
                value = 1; // First occurrence
            } else {
                value = value + 1; // Increment count
            }
            myHashTable.add(word, value);
        }

        // Display results to terminal
        System.out.println("--- Word Frequencies ---");
        for (String word : words) {
            System.out.println(word + " -> " + myHashTable.get(word));
        }

        // Assert/Verify frequencies match the requested sentence counts
        Integer toFrequency = myHashTable.get("to");
        Integer beFrequency = myHashTable.get("be");
        Integer orFrequency = myHashTable.get("or");

        Assert.assertEquals(Integer.valueOf(2), toFrequency);
        Assert.assertEquals(Integer.valueOf(2), beFrequency);
        Assert.assertEquals(Integer.valueOf(1), orFrequency);
    }
}
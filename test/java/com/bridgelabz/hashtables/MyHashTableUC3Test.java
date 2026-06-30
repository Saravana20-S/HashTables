package com.bridgelabz.hashtables;

import org.junit.Assert;
import org.junit.Test;

public class MyHashTableUC3Test {

    @Test
    public void givenALargeParagraph_WhenWordAvoidableIsRemoved_ShouldReturnNullOnGet() {
        String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";

        // Clean punctuation, convert to lowercase, and split by space
        String[] words = paragraph.toLowerCase().split("\\s+");

        // Initialize Hash Table with 20 buckets
        MyHashTable<String, Integer> myHashTable = new MyHashTable<>(20);

        // Populate the Hash Table with word frequencies
        for (String word : words) {
            Integer value = myHashTable.get(word);
            if (value == null) {
                value = 1;
            } else {
                value = value + 1;
            }
            myHashTable.add(word, value);
        }

        // Verify "avoidable" is initially present
        System.out.println("Before Removal -> avoidable frequency: " + myHashTable.get("avoidable"));
        Assert.assertNotNull(myHashTable.get("avoidable"));

        // UC3: Remove the word "avoidable" from the map
        Integer removedValue = myHashTable.remove("avoidable");
        System.out.println("Removed word 'avoidable' which had count: " + removedValue);

        // Verify "avoidable" is no longer accessible
        System.out.println("After Removal -> avoidable frequency: " + myHashTable.get("avoidable"));
        Assert.assertNull(myHashTable.get("avoidable"));
    }
}
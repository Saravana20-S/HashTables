package com.bridgelabz.hashtables;

import java.util.ArrayList;

public class MyHashTable<K, V> {
    private final int numBuckets;
    private final ArrayList<MyMapNode<K, V>> bucketArray;

    // Existing default constructor for backward compatibility (e.g., UC1)
    public MyHashTable() {
        this(10); // Automatically calls the overloaded constructor with 10 buckets
    }

    // Overloaded constructor to handle custom bucket counts dynamically (e.g., UC2)
    public MyHashTable(int bucketCount) {
        this.numBuckets = bucketCount;
        this.bucketArray = new ArrayList<>(numBuckets);

        // Initialize all buckets to null
        for (int i = 0; i < numBuckets; i++) {
            this.bucketArray.add(null);
        }
    }

    // Hash function to map a key to a specific bucket index
    private int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        return hashCode % numBuckets;
    }

    // UC1: Retrieve value for a given key
    public V get(K key) {
        int bucketIndex = this.getBucketIndex(key);
        MyMapNode<K, V> head = this.bucketArray.get(bucketIndex);

        // Loop through the linked list at this bucket index
        while (head != null) {
            if (head.getKey().equals(key)) {
                return head.getValue();
            }
            head = head.getNext();
        }
        return null; // Key doesn't exist yet
    }

    // UC1: Add or Update key-value pair in the Hash Table
    public void add(K key, V value) {
        int bucketIndex = this.getBucketIndex(key);
        MyMapNode<K, V> head = this.bucketArray.get(bucketIndex);
        MyMapNode<K, V> tempNode = head;

        // Check if the key already exists in the linked list chain
        while (tempNode != null) {
            if (tempNode.getKey().equals(key)) {
                tempNode.setValue(value); // Update value
                return;
            }
            tempNode = tempNode.getNext();
        }

        // Key doesn't exist, insert brand new node at the front of the chain
        MyMapNode<K, V> newNode = new MyMapNode<>(key, value);
        newNode.setNext(head);
        this.bucketArray.set(bucketIndex, newNode);
    }
}
# Custom Hash Table Implementation

A self-contained Java implementation of a Hash Table from scratch, utilizing an array of Linked Lists (`ArrayList` of custom `MyMapNode` objects) to gracefully handle index collisions using the chaining method.

## Features & Core Architecture
* **`MyMapNode<K, V>`**: A generic node configuration holding Key-Value pairs along with a pointer reference to the next node in the linked chain.
* **Collision Resolution**: Handled cleanly via an internal modular hash calculation: `Math.abs(key.hashCode()) % numBuckets`.
* **Scalable Buckets**: Supports an overloaded constructor to dynamically scale bucket counts to distribute high-density elements evenly.

---

## Use Cases Covered

### UC 1 - Basic Sentence Word Frequency
* Finds the occurrence frequency of words in a simple sentence phrase: *"To be or not to be"*.
* Demonstrates baseline mapping, tracking, and standard initialization within a 10-bucket threshold.

### UC 2 - Large Paragraph Map Distribution
* Calculates exact word frequencies across an extensive paragraph: *"Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations"*.
* Demonstrates the table's capability to scale bucket distribution (e.g., 20 buckets) to maintain high performance and minimize long internal list chaining.

### UC 3 - Key Removal Operations
* Introduces node removal capabilities to eliminate key-value pairings instantly.
* Tested and verified by completely removing the word `"avoidable"` from the paragraph data model and confirming its subsequent absence (`null` evaluation).

---

## Running the Unit Tests
Execute the test files inside your IDE or run the following Maven command at your project root:
```bash
mvn test

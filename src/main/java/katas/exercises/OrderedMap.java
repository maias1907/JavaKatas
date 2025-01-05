package katas.exercises;

public class OrderedMap<K, V> {
    /**
     * Implement an OrderedMap data structure that behaves like a regular map (dictionary) but maintains the
     * order of the keys based on their insertion order.
     *
     * Your task is to implement this class without using the SortedMap interface or similar utilities provided
     * by Java libraries.
     *
     * The order should be preserved as the keys are added to the map.
     */

    public OrderedMap() {

    }

    public void put(K key, V value) {
        /**
         * Add a key-value pair to the map.
         * If the key already exists, update its value while preserving the order.
         */
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public V get(K key) {
        /**
         * Retrieve the value associated with a given key.
         *
         * @param key: The key whose value is to be retrieved.
         * @return: The value associated with the key, or null if the key does not exist.
         */
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void remove(K key) {
        /**
         * Remove a key-value pair from the map.
         *
         * @param key: The key to be removed.
         */
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public List<K> keys() {
        /**
         * Return all keys in the order they were added.
         *
         * @return: A list of keys in insertion order.
         */
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public int size() {
        /**
         * Return the number of elements in the map.
         *
         * @return: The size of the map.
         */
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void clear() {
        /**
         * Remove all key-value pairs from the map.
         */
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public static void main(String[] args) {
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();

        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);

        System.out.println("Keys in order: " + orderedMap.keys());
        System.out.println("Value of 'Two': " + orderedMap.get("Two"));

        orderedMap.remove("Two");
        System.out.println("Keys after removal: " + orderedMap.keys());

        orderedMap.put("Two", 22);
        System.out.println("Keys after re-adding 'Two': " + orderedMap.keys());

        System.out.println("Map size: " + orderedMap.size());

        orderedMap.clear();
        System.out.println("Map size after clearing: " + orderedMap.size());
    }
}


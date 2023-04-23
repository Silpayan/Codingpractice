package leetcode.design;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
	
	public static void main(String s[]) {
		LRUCache lru = new LRUCache(5);
		
		System.out.println(lru.get(1));
		lru.put(1, 1);    lru.put(2, 2);    lru.put(3, 3);  lru.put(4, 4);  lru.put(5, 5);
		System.out.println(lru.get(2));
		lru.put(6, 6);
	}
	
    private Map<Integer, Integer> cache;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        float loadFactor = 1;
        cache = new LinkedHashMap<Integer, Integer>(capacity, loadFactor, true) { 
        	/*
        	 * Returns true if this map should remove its eldest entry. 
        	 * This method is invoked by put and putAll after inserting a new entry into the map.
        	 */
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) 
            { 
            	System.out.println("Current Map Size : "+size());
            	return size() > capacity; 
            }
        };
    }
    
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
        System.out.println("Cache : "+cache);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


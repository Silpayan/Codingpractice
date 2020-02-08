package leetcode.design;

import java.util.HashMap;
import java.util.Map;

class LRUCacheLCDiscussion {
	
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(5);
		
		System.out.println(lru.get(1));
		lru.put(1, 1);    lru.put(2, 2);    lru.put(3, 3);  lru.put(4, 4);  lru.put(5, 5);
		System.out.println(lru.get(2));
		lru.put(6, 6);
	}
	
    class DListNode {
        int key;
        int val;
        DListNode prev;
        DListNode next;

        public DListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, DListNode> map;
    DListNode oldestNode; //tracks 
    DListNode latestNode;
    int capacity;

    public LRUCacheLCDiscussion(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        DListNode node = map.get(key);
        if (node == null)
            return -1;
        else if (node.next == null)
            return node.val;
        else {
            if (node.prev == null) {
                oldestNode = node.next;
                oldestNode.prev = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.next = null;
            node.prev = latestNode;
            latestNode.next = node;
            latestNode = node;
            return node.val;
        }
    }

    public void put(int key, int value) {
        int val = get(key);
        if (val == -1) {
            if (map.size() == capacity) {
                map.remove(oldestNode.key);
                if (oldestNode.next != null)//remove the oldest node and point it to the next node
                    oldestNode.next.prev = null;
                oldestNode = oldestNode.next;
            }
            DListNode node = new DListNode(key, value);
            if (map.size() == 0) {
                oldestNode = node;
                latestNode = node;
            } else {
                latestNode.next = node;
                node.prev = latestNode;
                latestNode = node;
            }
            map.put(key, node);
        } else {
            map.get(key).val = value;
        }
    }
}

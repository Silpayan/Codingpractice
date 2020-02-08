package leetcode.design;

import java.util.HashMap;

public class Cache {

	public static void main(String[] args) {
		Cache lru = new Cache(5);
		
		System.out.println(lru.get(1));
		lru.put(1, 1);    lru.put(2, 2);    lru.put(3, 3);  lru.put(4, 4);  lru.put(5, 5);
		System.out.println(lru.get(2));
		lru.put(6, 6);
	}
	
	private int maxCacheSize;
	private HashMap<Integer, LinkedListNode> map = new HashMap<Integer, LinkedListNode>();
	private LinkedListNode listHead = null;
	public LinkedListNode listTail = null;

	
	
	public Cache(int maxSize) {
		maxCacheSize = maxSize;
	}

	/* Get value for key and mark as most recently used. */

	public int get(int key) {
		LinkedListNode item = map.get(key);
		if (item == null)
			return -1;

		/* Move to front of list to mark as most recently used. */
		if (item != listHead) {
			removeFromLinkedList(item);

			insertAtFrontOfLinkedList(item);
		}
		return item.value;
	}

	/*
	 * 
	 * Remove node from linked list.
	 */

	private void removeFromLinkedList(LinkedListNode node) {
		if (node == null)
			return;

		if (node.prev != null)
			node.prev.next = node.next;
		if (node.next != null)
			node.next.prev = node.prev;
		if (node == listTail)
			listTail = node.prev;
		if (node == listHead)
			listHead = node.next;
	}

	/*
	 * 
	 * Insert node at front of linked list.
	 */
	private void insertAtFrontOfLinkedList(LinkedListNode node) {
		if (listHead == null) {
			listHead = node;
			listTail = node;
		} else {
			listHead.prev = node;
			node.next = listHead;
			listHead = node;
		}
	}

	/* Remove key/value pair from cache, deleting from hashtable and linked list. */

	public boolean removeKey(int key) {

		LinkedListNode node = map.get(key);
		removeFromLinkedList(node);
		map.remove(key);
		return true;
	}

	/*
	 * Put key, value pair in cache. Removes old value for key if necessary .
	 * Inserts pair into linked list and hash table.
	 */

	public void put(int key, int value) {

		/* Remove if already there. */
		//removeKey(key);

		/* If full, remove least recently used item from cache. */
		if (map.size() >= maxCacheSize && listTail != null) {
			removeKey(listTail.key);
		}

		/* Insert new node. */
		LinkedListNode node = new LinkedListNode(key, value);
		insertAtFrontOfLinkedList(node);
		map.put(key, node);
	}

	private static class LinkedListNode {
		private LinkedListNode next, prev;
		public int key;
		public int value;

		public LinkedListNode(int k, int v) {
			key = k;
			value = v;
		}
	}
}
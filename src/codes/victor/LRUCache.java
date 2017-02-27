package codes.victor;

import java.util.HashMap;

/**
 * Created by victor on 23/02/2017.
 */
class LRUCache {

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 0; // Capacity of the LRUCache
    private int count = 0;

    Node head;
    Node tail;

    private HashMap<Integer, Node> map;

    private void deleteNode(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void addToHead(Node n) {
        n.next = head.next;
        n.next.prev = n;
        n.prev = head;
        head.next = n;
    }

    LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }

    int get(int key) {
        if(map.get(key) != null) {
            Node n = map.get(key);
            int result = n.value;
            deleteNode(n);
            addToHead(n);
            return result;
        }
        return -1;
    }

    void put(int key, int value) {
        if(map.get(key) != null) {
            Node n = map.get(key);
            n.value = value;
            deleteNode(n);
            addToHead(n);
        } else {
            Node n = new Node(key, value);
            map.put(key, n);
            if (count < capacity) {
                count++;
                addToHead(n);
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(n);
            }
        }
    }
}

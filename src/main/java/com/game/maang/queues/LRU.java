package com.game.maang.queues;

import java.util.HashMap;
import java.util.Map;

class Node<K,V>{
    K key;
    V value;
    Node<K,V> next;
    Node<K,V> prev;
    Node(K key,V value){
        this.key = key;
        this.value = value;
    }
}

// Implement the Doubly Linked List
class DoublyLinkedList<K,V>{
    Node<K,V> head;
    Node<K,V> tail;
    int capacity;
    DoublyLinkedList(int capacity){
        this.capacity = capacity;
        head = null;
        tail = null;
    }
    // insert
    public boolean add(K key,V value){
        Node<K,V> node = new Node<>(key,value);
        if(head == null) {
            head = tail = node;
            return true;
        }
        head.prev = node;
        node.next = head;
        head = node;

        return false;
    }
    // move to head
    public boolean moveToHead(K key){
        if(head == null )return false;
        if(head.key == key ) return true;
        Node<K,V> ptr = head;
        while(ptr != null){
            if(ptr.key == key) {
                ptr.prev.next = ptr.next;
                if(ptr.next != null)ptr.next.prev = ptr.prev;
                ptr.prev =null;
                ptr.next = head;
                head.prev = ptr;
                head = ptr;
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }
    // remove from tail
    public boolean removeFromTail(){
        if(tail == null) return false;
        tail = tail.prev;
        tail.next.prev = null;
        tail.next = null;
        return true;
    }
    // display
    public void display(){
        Node<K,V> ptr = head;
        while(ptr != null) {
            System.out.print("["+ptr.key+","+ptr.value+"]|->");
            ptr = ptr.next;
        }
        System.out.println();
    }
}
class LRUCache<K,V>{
    Map<K,V> map;
    DoublyLinkedList<K,V> linkedList;
    LRUCache(int capacity){
        map = new HashMap<>(capacity);
        linkedList = new DoublyLinkedList<>(capacity);
    }
    public void get(K key){
        if(map.containsKey(key)){
            linkedList.moveToHead(key);
            System.out.println("["+key+","+map.get(key)+"] marked latest");
        }else{
            System.out.println("Page fault");
        }
    }
    public void put(K key,V value){
        if(map.containsKey(key)){
            linkedList.moveToHead(key);
            System.out.println("["+key+","+value+"] already present. Marked latest");
        }else{
            map.put(key,value);
            linkedList.add(key,value);
            System.out.println("["+key+","+value+"] added to the cache");
        }
    }

    public void display(){
        linkedList.display();
    }
}
public class LRU {
    public static void main(String[] args) {
//        Testing of the Doubly Linked list created.
//        DoublyLinkedList<Integer, String> doublyLinkedList = new DoublyLinkedList<>(3);
//        doublyLinkedList.add(1,"A");
//        doublyLinkedList.display();
//        doublyLinkedList.add(2,"B");
//        doublyLinkedList.add(3,"C");
//        doublyLinkedList.display();
//        doublyLinkedList.moveToHead(1);
//        doublyLinkedList.display();
//        doublyLinkedList.moveToHead(2);
//        doublyLinkedList.display();
//        doublyLinkedList.moveToHead(3);
//        doublyLinkedList.display();

//        LRU Cache testing
        LRUCache<Integer,String> lru = new LRUCache<>(3);
        lru.put(1,"Akshay");
        lru.put(2,"Bittu");
        lru.display();
        lru.put(1,"Akshay");
        lru.display();
        lru.put(3,"Pranay");
        lru.display();
        lru.get(2);
        lru.display();
    }
}
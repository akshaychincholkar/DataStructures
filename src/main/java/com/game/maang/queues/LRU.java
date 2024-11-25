package com.game.maang.queues;

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

public class LRU {
    // Implement Node for the Doubly LL


    // Create LRUCache

    // Use it in main
    public static void main(String[] args) {
        DoublyLinkedList<Integer, String> doublyLinkedList = new DoublyLinkedList<>(3);
        doublyLinkedList.add(1,"A");
        doublyLinkedList.display();
        doublyLinkedList.add(2,"B");
        doublyLinkedList.add(3,"C");
        doublyLinkedList.display();
        doublyLinkedList.moveToHead(1);
        doublyLinkedList.display();
        doublyLinkedList.moveToHead(2);
        doublyLinkedList.display();
        doublyLinkedList.moveToHead(3);
        doublyLinkedList.display();
    }
}
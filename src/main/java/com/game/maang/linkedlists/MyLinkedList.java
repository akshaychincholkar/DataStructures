package com.game.maang.linkedlists;

import java.lang.ref.Cleaner;

public class MyLinkedList {

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public void add(int data){
        Node node = new Node(data);

        if(head==null) head = node;
        else{
            node.next = head;
            head = node;
        }
        System.out.println(data+ " added to the linked list");
    }
    public void remove(int data){
        if(head == null ) return ;
        Node ptr = head;
        Node prev = null;
        while(ptr!=null){
            if(ptr.data == data) break;
            prev = ptr;
            ptr = ptr.next;
        }
        if(ptr != null){
            if(ptr == head){
                head = head.next;
                return;
            }
            prev.next = ptr.next;
            return;
        }
    }
    public void display(){
        Node ptr = head;
        while(ptr != null){
            System.out.print("|"+ptr.data+"| ->");
            ptr = ptr.next;
        }
        System.out.println();
    }
    public void displayCircularList(){
        Node ptr = head.next;
        System.out.println("Printing the circular linked list:");
        System.out.print("|"+head.data+"| ->");
        while(ptr != head){
            System.out.print("|"+ptr.data+"| ->");
            ptr = ptr.next;
        }
        System.out.println();
    }
    public boolean search(int data){
        Node ptr = head;
        while(ptr != null){
            if(ptr.data == data){
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }
    public int getElementAtIndex(int index){
        Node ptr = head;
        int i =1;
        while(i <= index && ptr != null){
            if(i == index) return ptr.data;
            i++;
            ptr = ptr.next;
        }
        System.out.println("[INVALID INPUT] Check index");
        return -1;
    }
    public static MyLinkedList createLinkedList(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        return linkedList;
    }
    public static MyLinkedList createSortedList_1(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(9);
        linkedList.add(7);
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(1);
        return linkedList;
    }
    public static MyLinkedList createSortedList_2(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(8);
        linkedList.add(6);
        linkedList.add(3);
        linkedList.add(2);
        return linkedList;
    }
    public static MyLinkedList createPalindromeLinkedList(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(1);
        linkedList.add(4);
        linkedList.add(5);
        return linkedList;
    }
    public static MyLinkedList createLoopedLinkedList(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        Node ptr = linkedList.head,prev = null;
        while(ptr.next!=null){
            prev = ptr;
            ptr = ptr.next;
        }
        ptr.next = prev;
        System.out.println("Loop created");
        return linkedList;
    }

    public int length(){
        Node ptr = head;
        int length = 0;
        while(ptr != null){
            length++;
            ptr = ptr.next;
        }
        return length;
    }
    public void reverse(){

        if(head == null || head.next == null){
            return ;
        }
        Node prev=null,ptr= head,next = head.next;
        while(next!=null){
            ptr.next = prev;
            prev = ptr;
            ptr = next;
            next = next.next;
        }
        ptr.next = prev;
        head = ptr;
    }
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        System.out.println("Length :"+linkedList.length());
        linkedList.display();
        linkedList.remove(2); //first element check
        linkedList.display();
        linkedList.remove(5); // last element remove check
        linkedList.display();
        System.out.println("3rd index element:"+linkedList.getElementAtIndex(3));
        System.out.println("3rd index element:"+linkedList.getElementAtIndex(4));
        System.out.println("Searching 1: "+(linkedList.search(1)?"Present":"Absent"));
        System.out.println("Length: "+linkedList.length());
    }
}

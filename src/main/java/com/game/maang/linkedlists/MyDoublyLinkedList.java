package com.game.maang.linkedlists;

public class MyDoublyLinkedList {
    class Node{
        int data;
        Node nptr;
        Node pptr;
        Node(int data){
            this.data = data;
        }
    }
    Node head = null;
    public void add(int data){
        Node node = new Node(data);
        if(head == null ){
            head = node;
        }else{
            node.nptr = head;
            head.pptr = node;
            head = node;
        }
        System.out.println("Node "+data+" added to the doubly linked list");
    }
    public void display(){
        Node ptr = head;
        while(ptr!=null){
            System.out.print(ptr.data+"->");
            ptr = ptr.nptr;
        }
        System.out.println();
    }
    public void createDoublyLinkedList(){
        Node node1 = new Node(5);
        Node node2 = new Node(4);
        Node node3 = new Node(1);
        Node node4 = new Node(3);
        Node node5 = new Node(2);

        node1.pptr = head;
    }
    public static void main(String[] args) {
        MyDoublyLinkedList doublyLinkedList = new MyDoublyLinkedList();
        doublyLinkedList.add(5);
        doublyLinkedList.add(4);
        doublyLinkedList.add(1);
        doublyLinkedList.add(3);
        doublyLinkedList.add(2);
        doublyLinkedList.display();
    }
}

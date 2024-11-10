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
    public boolean search(int value){
        Node ptr = head;
        while(ptr!=null){
            if(ptr.data == value){
                return true;
            }
            ptr = ptr.nptr;
        }
        return false;
    }
    public boolean delete(int value){
        Node ptr = head,prev = null;
        while(ptr!=null){
            if(ptr.data == value){
                ptr.nptr.pptr = prev;
                if(prev != null) prev.nptr = ptr.nptr;
                else head = head.nptr;
                return true;
            }
            prev = ptr;
            ptr = ptr.nptr;
        }
        return false;
    }
    public int length(){
        int i = 0;
        Node ptr = head;
        while(ptr!= null){
            i++;
            ptr = ptr.nptr;
        }
        return i;
    }
    public int getElementFromIndex(int index){
        if( index >= length() || index <0) return -1;
        int l_index =0;
        for(Node ptr = head;ptr!=null;ptr=ptr.nptr,l_index++){
            if(l_index == index) return ptr.data;
        }
        return -1;
    }
    public void createDoublyLinkedList(){
        MyDoublyLinkedList doublyLinkedList = new MyDoublyLinkedList();
        doublyLinkedList.add(5);
        doublyLinkedList.add(4);
        doublyLinkedList.add(1);
        doublyLinkedList.add(3);
        doublyLinkedList.add(2);
    }

    public static void main(String[] args) {
        MyDoublyLinkedList doublyLinkedList = new MyDoublyLinkedList();
        doublyLinkedList.add(5);
        doublyLinkedList.add(4);
        doublyLinkedList.add(1);
        doublyLinkedList.add(3);
        doublyLinkedList.add(2);
        doublyLinkedList.display();
        System.out.println("Element at index 0: "+doublyLinkedList.getElementFromIndex(0));
        System.out.println("Element at index 4: "+doublyLinkedList.getElementFromIndex(4));
        System.out.println("Element at index 2: "+doublyLinkedList.getElementFromIndex(2));
        System.out.println("Element at index 12: "+doublyLinkedList.getElementFromIndex(12));
        System.out.println("The value 3 present: "+(doublyLinkedList.search(3)?"Yes":"No"));
        System.out.println("The value 13 present: "+(doublyLinkedList.search(13)?"Yes":"No"));
        System.out.println("Value 3 deleted: "+(doublyLinkedList.delete(3)?"Yes":"No"));
        doublyLinkedList.display();
        System.out.println("Value 12 deleted: "+(doublyLinkedList.delete(12)?"Yes":"No"));
        System.out.println("Value 2 deleted: "+(doublyLinkedList.delete(2)?"Yes":"No"));
        doublyLinkedList.display();
    }
}

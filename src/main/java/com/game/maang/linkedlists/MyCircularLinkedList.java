package com.game.maang.linkedlists;

public class MyCircularLinkedList {
    class Node{
        int data;
        MyCircularLinkedList.Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public Node head;
    public void add(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        }else{
            node.next = head;
            head = node;
        }
        System.out.println("Node created: "+data);
    }
    public static MyCircularLinkedList create(){
        MyCircularLinkedList linkedList = new MyCircularLinkedList();
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        MyCircularLinkedList.Node ptr = linkedList.head;
        while(ptr.next!=null){
            ptr = ptr.next;
        }
        ptr.next = linkedList.head;
        System.out.println("Loop created");
        return linkedList;
    }
    public void display(){
        Node ptr = head.next;
        System.out.print(head.data+"->");
        while(ptr!=head){
            System.out.print(ptr.data+"->");
            ptr = ptr.next;
        }
        System.out.println();
    }
    public int search(int value){
        if(head == null) return -1;
        if(head.data == value) return 0;
        Node ptr = head.next;
        int index = 1;
        while(ptr != head){
            if(ptr.data == value) return index;
            ptr = ptr.next;
            index++;
        }
        return -1;
    }
    public int length(){
        if(head == null) return 0;
        if(head.next == null) return 1;
        Node ptr = head.next;
        int length = 1;
        while(ptr!=head){
            length++;
            ptr = ptr.next;
        }
        return length;
    }
    public int getElementFromIndex(int index){
        if(index == -1 || index >= length() || index < 0) return -1;
        if(index == 0) return head.data;
        Node ptr = head.next;
        for(int i= 1 ; ptr!= head; i++,ptr = ptr.next){
            if(index == i) return ptr.data;
        }
        return -1;
    }
    public boolean delete(int value){
        int index = search(value);
        if(index == -1) return false;
        if(index == 0) head = head.next;
        Node ptr = head.next, prev = head;
        while(ptr != head){
            if(ptr.data == value) {
                prev.next = ptr.next;
                return true;
            }
            prev = ptr;
            ptr = ptr.next;
        }
        return false;
    }
    public static void main(String[] args) {
        MyCircularLinkedList circularList = MyCircularLinkedList.create();
        circularList.display();
        System.out.println("Value 5 present: "+(circularList.search(5)!=-1?"Yes at "+circularList.search(5):"No"));
        System.out.println("Value 15 present: "+(circularList.search(15)!=-1?"Yes":"No"));
        System.out.println("Length :"+circularList.length());
        System.out.println("Third element:"+circularList.getElementFromIndex(3));
        System.out.println("Deleted 4 from the circular linked list: "+circularList.delete(4));
        circularList.display();
    }
}

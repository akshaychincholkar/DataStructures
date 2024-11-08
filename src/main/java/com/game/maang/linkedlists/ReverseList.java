package com.game.maang.linkedlists;

public class ReverseList {
    public static MyLinkedList reverse(MyLinkedList list){
        
        if(list.head == null || list.head.next == null){
            return list;
        }
        MyLinkedList.Node prev=null,ptr= list.head,next = list.head.next;
        while(next!=null){
            ptr.next = prev;
            prev = ptr;
            ptr = next;
            next = next.next;
        }
        ptr.next = prev;
        list.head = ptr;
        return list;
    }


    public static void main(String[] args) {
        MyLinkedList list = MyLinkedList.createLinkedList();
        list.display();
        list = reverse(list);
        list.display();
        // OR method is created in linked list itself
        list.reverse();
        list.display();
    }
}

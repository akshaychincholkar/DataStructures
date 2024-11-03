package com.game.maang.linkedlists;

public class RotateList {
    public static void rotate(MyLinkedList list,int r){
        MyLinkedList.Node ptr = list.head, r_ptr = list.head;
        r = r % list.length();
        while(ptr.next != null){
            if(r > 0) {
                r--;
                ptr = ptr.next;
                continue;
            }
            ptr = ptr.next;
            r_ptr = r_ptr.next;
        }
        ptr.next = list.head;
        list.head = r_ptr.next;
        r_ptr.next = null;
    }

    public static void main(String[] args) {
        MyLinkedList list = MyLinkedList.createLinkedList();
        list.display();
        rotate(list,2);
        list.display();
    }
}

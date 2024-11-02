package com.game.maang.linkedlists;

public class DetectLoop {
    public static boolean  detect(MyLinkedList list){
        MyLinkedList.Node fastptr = list.head,slowptr = list.head;
        do{
            if(fastptr == null || fastptr.next == null || slowptr == null) return false;
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
        }while(fastptr != slowptr);
        return  true;
    }

    public static void main(String[] args) {
        MyLinkedList list = MyLinkedList.createLoopedLinkedList();
        System.out.println("Is linked list contains loop: "+detect(list));
        list = MyLinkedList.createLinkedList();
        System.out.println("Is linked list contains loop: "+detect(list));

    }
}

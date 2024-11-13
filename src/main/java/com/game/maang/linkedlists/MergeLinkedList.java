package com.game.maang.linkedlists;

public class MergeLinkedList {
    public static MyLinkedList merge(MyLinkedList list1,MyLinkedList list2){
        MyLinkedList list3 = new MyLinkedList();
        MyLinkedList.Node ptr1 = list1.head, ptr2 = list2.head;
        while(ptr1!=null && ptr2 != null){
            if(ptr1.data < ptr2.data){
                list3.add(ptr1.data);
                ptr1 = ptr1.next;
            }else{
                list3.add(ptr2.data);
                ptr2 = ptr2.next;
            }
        }
        while(ptr1!=null){
            list3.add(ptr1.data);
            ptr1 = ptr1.next;
        }
        while(ptr2 != null){
            list3.add(ptr2.data);
            ptr2 = ptr2.next;
        }
        list3.reverse();
        return list3;
    }

    public static void main(String[] args) {
        MyLinkedList list1 = MyLinkedList.createSortedList_1();
        System.out.println("List 1: ");
        list1.display();
        MyLinkedList list2 = MyLinkedList.createSortedList_2();
        System.out.println("List 2: ");
        list2.display();
        System.out.println("Result: ");
        merge(list1,list2).display();
    }
}

package com.game.maang.linkedlists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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

//        Java LinkedList merging
        LinkedList<Integer> linkedlist1 = new LinkedList<>(Arrays.asList(1,3,4,6,7));
        LinkedList<Integer> linkedlist2 = new LinkedList<>(Arrays.asList(2,5,8,9,10));
        System.out.println(linkedlist1);
        System.out.println(linkedlist2);
        System.out.println(mergeLL(linkedlist1,linkedlist2));
    }

    private static LinkedList<Integer> mergeLL(LinkedList<Integer> linkedlist1, LinkedList<Integer> linkedlist2) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        while(!linkedlist1.isEmpty() && !linkedlist2.isEmpty()){
            if(linkedlist1.peek()<linkedlist2.peek())linkedList.add(linkedlist1.remove());
            else linkedList.add(linkedlist2.remove());
        }
        while(!linkedlist1.isEmpty())linkedList.add(linkedlist1.remove());
        while(!linkedlist2.isEmpty())linkedList.add(linkedlist2.remove());
        return linkedList;
    }
}

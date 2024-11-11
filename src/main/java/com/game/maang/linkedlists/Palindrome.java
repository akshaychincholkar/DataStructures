package com.game.maang.linkedlists;

public class Palindrome {
    public static boolean isPalindrome(MyLinkedList list){
        MyLinkedList.Node head = list.head;
        if(head == null || head.next == null) return true;
        MyLinkedList.Node slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        MyLinkedList.Node prev = null, ptr = slow,next = slow.next;
        while(next!=null){
            ptr.next = prev;
            prev = ptr;
            ptr = next;
            next = next.next;
        }
        //Now compare head and fast
        fast = ptr;
        MyLinkedList.Node head_s = head;
        while(fast != null){
            if(head_s.data != fast.data) return false;
            head_s = head_s.next;
            fast = fast.next;
        }
        return true;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList =  MyLinkedList.createPalindromeLinkedList();
        System.out.println("The linked list "+(isPalindrome(linkedList)?"is":"is not")+" Palindrome");
    }
}


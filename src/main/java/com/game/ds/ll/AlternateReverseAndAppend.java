package com.game.ds.ll;

public class AlternateReverseAndAppend {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static void printList(Node head){
        Node ptr = head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }
    public static void rearrange(Node head){
        if(head == null || head.next ==null || head.next.next == null) return;
        Node odd = head;
        Node even = odd.next;
        odd.next = odd.next.next;
        Node head2 = even;
        even.next = null;
        odd = odd.next;
        while(odd.next != null){
            Node temp = odd.next;
            if(odd.next.next != null) {
                odd.next = odd.next.next;
            }
            temp.next= even;
            even = temp;
            if(odd.next!=null)odd = odd.next;
        }
        odd.next = even;
    }
    public static void main(String[] args){
        AlternateReverseAndAppend list = new AlternateReverseAndAppend();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);


        System.out.println("Linked list before calling rearrange : ");
        list.printList(head);

        System.out.println("");
        list.rearrange(head);

        System.out.println("Linked list after calling rearrange : ");
        list.printList(head);



    }

}

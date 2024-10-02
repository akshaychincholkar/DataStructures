package com.game.ds.ll;


class Node {
    int data;
    Node next, random;

    Node(int x) {
        data = x;
        next = random = null;
    }
}
public class CloneLLRandomPointer {
    public static void main(String[] args) {
        // Creating a linked list with random pointer
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;

        // Print the original list
        System.out.println("The original linked list:");
        printList(head);

        // Function call
        Node sol = cloneLinkedList(head);

        System.out.println("The cloned linked list:");
        printList(sol);
    }
    public static Node cloneLinkedList(Node head){
        Node cur = head;
        // Add the new nodes to the next of each nodes
        while(cur != null){
            Node newNode = new Node(cur.data);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }
        // Apply the random pointers to the new nodes
        cur = head;
        while(cur != null){
            cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        // reset the cloning by next pointing to appropriate node
        Node clonedHead = head.next;
        cur = head;
        Node clncur = head.next;
        while(clncur.next!=null){
            cur.next = clncur.next;
            if(clncur.next != null)clncur.next = clncur.next.next;
            clncur = clncur.next;
            cur = cur.next;
        }
        cur.next = null;
        return clonedHead;
    }
    public static void printList(Node head){
        Node cur = head;
        while(cur !=null){
            System.out.print(cur.data+"("+cur.random.data+")->");
            cur = cur.next;
        }
        System.out.print("null");
    }
}

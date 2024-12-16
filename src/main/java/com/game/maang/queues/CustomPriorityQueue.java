package com.game.maang.queues;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CustomPriorityQueue {
//    class Node{
//        int data;
//        Node left;
//        Node right;
//        Node(int data){ this.data = data;}
//    }
//    Node root = null;
//    public void enque(int value){
//        if(root == null){
//            Node node = new Node(value);
//            root = node;
//            return;
//        }
//        insertNodeToHeap(root,value);
//    }
//
//    private void insertNodeToHeap(Node root,int value) {
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//
//    }
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(5);
        queue.add(4);
        queue.add(1);
        queue.add(3);
        queue.add(2);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}

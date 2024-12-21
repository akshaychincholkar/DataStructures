package com.game.maang.queues;

import java.util.LinkedList;
import java.util.Queue;

public class FrontOFQueue {
    public static void main(String[] args) {
        Queue<Integer> queue  = new LinkedList<>();
//        queue.add(5);
//        queue.add(4);
//        queue.add(1);
//        queue.add(3);
//        queue.add(2);
        System.out.println("Front of queue is :"+(queue.peek() == null?" Queue is empty.":queue.peek()));
    }
}

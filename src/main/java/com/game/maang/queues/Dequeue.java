package com.game.maang.queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class DequeueUsingArray{
    public static void demonstrate() {
        Deque<Integer> dequeue = new ArrayDeque<>();
        dequeue.addFirst(5);
        dequeue.addFirst(4);
        System.out.println(dequeue);
        dequeue.addLast(1);
        dequeue.addFirst(3);
        dequeue.addLast(2);
        System.out.println(dequeue);
    }
}
class DequeueUsingLL{
    public static void demonstrate(){
        Deque<Integer> dequeue = new LinkedList<>();
        dequeue.addFirst(5);
        dequeue.addFirst(4);
        System.out.println(dequeue);
        dequeue.addLast(1);
        dequeue.addFirst(3);
        dequeue.addLast(2);
        System.out.println(dequeue);
    }
}
public class Dequeue {
    public static void main(String[] args) {
        DequeueUsingArray.demonstrate();
        DequeueUsingLL.demonstrate();
    }
}

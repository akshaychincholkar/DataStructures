package com.game.ds.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueueUsingStack {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i<=10;i++)queue.add(i);
        printQueue(queue);
        reverseQueue(queue);
        printQueue(queue);
    }
    public static void printQueue(Queue queue){
        System.out.println(queue);
    }
    public static void reverseQueue(Queue queue){
        Stack stack = new Stack();
        while(!queue.isEmpty()){
            stack.push(queue.remove());
        }
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
    }
}

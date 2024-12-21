package com.game.maang.queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(queue);
        reverseQueue(queue);
        System.out.println(queue);
    }
    public static void  reverseQueue(Queue queue){
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()){
            stack.push((Integer) queue.poll());
        }
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
    }
}

package com.game.maang.queues;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    QueueUsingStack(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void enque(int value){
        stack1.push(value);
    }
    public int deque(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            System.out.println("[UNDERFLOW]:Queue is empty");
            return -1;
        }
        if(stack2.isEmpty()){
            while(!stack1.isEmpty())stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.enque(5);
        queue.enque(4);
        System.out.println(queue.deque());  // 5
        queue.enque(1);
        queue.enque(3);
        queue.enque(2);

        System.out.println(queue.deque()); // 4
        System.out.println(queue.deque()); // 1
        System.out.println(queue.deque()); // 3
        System.out.println(queue.deque()); // 2
        System.out.println(queue.deque()); // Underflow
    }
}

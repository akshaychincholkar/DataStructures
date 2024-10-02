package com.game.ds.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementInQueue {
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1;i<= 10;i++)queue.add(i);
        System.out.println(queue);
        reverseQueueUsingRecursion(queue,3);
        System.out.println(queue);
    }
    public static void reverseQueueUsingRecursion(Queue queue, int k){
        Stack stack = new Stack();
        int t = k;
        while(k>0){
            stack.push(queue.remove());
            k--;
        }
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
        int n = queue.size() - t;
        System.out.println(n);
        for(int i = 0; i<n;i++){
            int temp = (int) queue.remove();
            queue.add(temp);
        }
    }
}

package com.game.ds.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueueUsingRecursion{
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1;i<= 10;i++)queue.add(i);
        System.out.println(queue);
        reverseQueueUsingRecursion(queue);
        System.out.println(queue);
    }
    public static void reverseQueueUsingRecursion(Queue queue){
        if(queue.isEmpty()) return;
        int temp = (int) queue.remove();
        reverseQueueUsingRecursion(queue);
        queue.add(temp);
    }
}
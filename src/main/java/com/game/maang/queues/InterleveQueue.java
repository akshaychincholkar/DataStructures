package com.game.maang.queues;

import java.util.LinkedList;
import java.util.Queue;

public class InterleveQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);

        System.out.println(queue);
        interleveQueue(queue);
        System.out.println(queue);
    }

    private static void interleveQueue(Queue<Integer> queue) {
        Queue<Integer> temp = new LinkedList<>();
        int length = queue.size()/2;
        if(length%2 !=0){
            throw new IllegalArgumentException("Queue must be even sized to interleve");
        }
        System.out.println(length);
        for(int i=0;i<length;i++){
            temp.add(queue.poll());
        }
        // add the elements one by one
        while(!temp.isEmpty()){
            queue.add(temp.poll());
            queue.add(queue.poll());
        }
    }
}

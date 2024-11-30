package com.game.maang.queues;

import java.util.LinkedList;
import java.util.Queue;

public class Binary {
    public static void main(String[] args) {
        getBinary(10);
    }

    private static void getBinary(int n) {
        Queue<String> queue = new LinkedList<>();

        // Start with the first binary number
        queue.add("1");

        System.out.println("First " + n + " binary numbers:");

        for (int i = 0; i < n; i++) {
            // Dequeue the front element
            String binary = queue.poll();
            System.out.println(binary);

            // Enqueue the next two binary numbers
            queue.add(binary + "0");
            queue.add(binary + "1");
        }
    }
}

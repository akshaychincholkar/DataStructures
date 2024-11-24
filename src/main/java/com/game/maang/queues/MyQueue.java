package com.game.maang.queues;

public class MyQueue {
    int[] queue;
    int capacity;
    int front;
    int rear;
    int size;
    public MyQueue(int capacity){
        this.capacity = capacity;
        queue = new int[capacity];
        size = front = rear = 0;
    }
    public boolean add(int value){
        if(size == capacity && front == rear){
            System.out.println("[OVERFLOW]: Queue is full");
            return false;
        }
        queue[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

}
